<template>
  <body>
    <div class="login">
      <div class="container">
        <div class="row">
          <div class="col-sm-4">
            <header class="visually-hidden">
              <h1>E-commerce</h1>
            </header>

            <div class="login-header">
              <h2>로그인</h2>
            </div>

            <div class="login-line"></div>

            <section class="login-section">
              <div class="login-member">
                <form class="login-form" action="/" method="POST">
                  <div class="login-member-form">
                    <div class="login-member-id">
                      <input
                        class="login-input"
                        type="email"
                        placeholder="이메일을 입력해주세요"
                        required
                      />
                    </div>
                    <div class="login-member-password">
                      <input
                        class="login-input"
                        type="password"
                        placeholder="비밀번호를 입력해주세요"
                        required
                      />
                    </div>
                  </div>

                  <button class="btn-black btn-46">로그인</button>

                  <div class="login-util">
                    <div class="login-util-check">
                      <input type="checkbox" />
                      <label for="">자동로그인</label>
                    </div>

                    <div>
                      <ul class="login-util-find">
                        <li class="login-util-find id">
                          <a href="/">아이디 찾기</a>
                        </li>
                        <li class="login-util-find password">
                          <a href="/">비밀번호 찾기</a>
                        </li>
                      </ul>
                    </div>
                  </div>
                </form>

                <div class="login-btn social">
                  <button class="login-btn-kakao">카카오 로그인</button>
                  <button class="login-btn-naver">네이버 로그인</button>
                </div>
              </div>

              <div class="login-bottom-text">
                <span>가입만 해도 즉시 15% 할인</span>
                <a href="/">회원가입</a>
              </div>
            </section>
          </div>
        </div>
      </div>
    </div>
  </body>
</template>
<script>
export default {}
</script>
<style lang="scss" scoped>
@import "~@/assets/scss/pages/login";
</style>
