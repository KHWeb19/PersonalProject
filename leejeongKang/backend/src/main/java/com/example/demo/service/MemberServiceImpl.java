package com.example.demo.service;

import com.example.demo.controller.request.MemberRequest;
import com.example.demo.entity.Member;
import com.example.demo.entity.MemberAuth;
import com.example.demo.repository.MemberAuthRepository;
import com.example.demo.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;  //엔티티 조회, 저장, 삭제

    @Autowired
    private MemberAuthRepository memberAuthRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void register (MemberRequest memberRequest) {
        String encodedPassword = passwordEncoder.encode(memberRequest.getPassword());
        memberRequest.setPassword(encodedPassword);
        MemberAuth authEntity = new MemberAuth(memberRequest.getAuth());
        Member memberEntity = new Member(
                memberRequest.getId(), memberRequest.getPassword(), memberRequest.getName(), memberRequest.getBirth(),
                memberRequest.getPhone());
        memberEntity.addAuth(authEntity);

        memberRepository.save(memberEntity);
    }

    @Override
    public MemberRequest login (MemberRequest memberRequest) {
        Optional<Member> maybeMember = memberRepository.findById(memberRequest.getId());

        if(maybeMember == null) {
            log.info("로그인 실패");
            return null;
        }

        Member loginMember = maybeMember.get();
        if(!passwordEncoder.matches(memberRequest.getPassword(), loginMember.getPassword())) {
            log.info("비밀번호 잘못 입력했습니다.");
            return null;
        }

        Optional<MemberAuth> maybeMemberAuth = memberAuthRepository.findByMemberNo(loginMember.getMember_no());

        if(maybeMemberAuth == null ){
            log.info("auth  없음");
            return null;
        }

        MemberAuth memberAuth = maybeMemberAuth.get();

        MemberRequest response = new MemberRequest(
                memberRequest.getId(),
                null,
                memberRequest.getName(),
                memberRequest.getBirth(),
                memberRequest.getPhone(),
                memberAuth.getAuth());
        return response;
    }
}
