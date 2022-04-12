package com.example.demo.security.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsServiceImpl userDetailsService;
    private final CorsConfigurationSource corsConfigurationSource;
    private final HttpCookieOauth2AuthorizationRequestRepository httpCookieOauth2AuthorizationRequestRepository;
    private final CustomOauth2UserService customOauth2UserService;
    private final OAuth2SuccessHandler oAuth2SuccessHandler;
    private final OAuth2FailureHandler oAuth2FailureHandler;
    private final AuthEntryPointJwt unauthorizedHandler;
    private final AuthToKenFilter authToKenFilter;

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        // 인증 매니저 빌더를 이용해 userDetailsService 및 passwordEncoder 설정
        authenticationManagerBuilder.userDeatilsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        // 인증 매니저 객체 Bean으로 등록
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // BCrypt 패스워드 인코더 객체 Bean 으로 등록
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // CORS 설정(설정 소스는 CorsConfigurationSource 클래스에 작성)
        http.cors().configurationSource(corsConfigurationSource.getSource());
        // CSRF 보호 기능 미사용 처리(브라우저를 통해 요청을 받지 않는다면 disable 처리해도 무방)
        http.csrf().disable();
        // 세션 관리 정책을 SATELESS로 설정 (세션 관리를 하지 않겠다는 의미)
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // 폼 로그인 방식 비활성화
        http.formLopgin().disable();
        // 기본 로그인 인증 화면 비활성화
        http.httpBasic().disable();
        // Exception 핸들링 및 인증 진입지점 설정
        http.exceptionHandling().authenticationEntryPoint(unauthorizedHandler);
        // 승인할 요청들에 대한 설정
        http.authoirzeRequests()
                // 접근 가능한 URL 패턴들 지정
                .antMatchers("/", "/error", "/favicon.ico","/**/*.html", "/**/*.css", "/**/*.js", "/**/*.png", "/**/*/.jpg", "/**/*.svg", "/h2-console/**").permitAll()
                .antMathcers("/login/**", "auth/**", "/outh2/**").permitAll()
                // 다른 요청들은 인증이 되어야 접근 가능
                .anyRequest().authenticated();
        // OAuth2 로그인에 대한 설정
        http.oauth2Login()
                // 승인 종료지점 기본 URI 설정 및 승인 요청 저장소 설정
                .authorizationEndpoint().baseUri("/oauth2/authorize").authorizationRequestRepository(httpCookieOauth2AuthorizationRequestRepository).and()
                // 리다이렉트 종료지점 기본 URI 설정
                .redirectionEndpoint().baseUri("/login/oauth2/code/*").and()
                // User 정보 종료 지점 및 User 서비스 설정(User 정보 DB정보 저장 및 조회)
                .userInfoEndpoint().userService(customOauth2UserService).and()
                // OAuth2 로그인 성공 시 호출되는 이벤트 핸들러
                .successHandler(oAuth2SuccessHandler)
                // OAuth2 로그인 실패 시 호출되는 이벤트 핸들러
                .failureHandler(oAuth2FailureHandler);
        // 헤더 정보의 X-Frame-Options를 비활성화 하는 설정
        http.headers().frameOptions().disable();
        // UsernamePasswordAuthenticationFilter 앞에 AuthTokenFilter를 추가하여 먼저 실행되도록 설정
        http.addFilterBefore(authToKenFilter, UsernamePasswordAuthenticationFilter.class);
    }

}
