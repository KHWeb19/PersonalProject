package com.example.demo.service.member;

import com.example.demo.controller.memberController.request.MemberRequest;
import com.example.demo.entity.member.Member;
import com.example.demo.entity.member.MemberAuth;
import com.example.demo.repository.MemberAuthRepository;
import com.example.demo.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberAuthRepository memberAuthRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Transactional
    @Override
    public void register(MemberRequest memberRequest) {
        String encodedPassword = passwordEncoder.encode(memberRequest.getPw());
        memberRequest.setPw(encodedPassword);

        Member memberEntity = new Member(
                memberRequest.getId(), memberRequest.getPw());

        memberRepository.save(memberEntity);

        MemberAuth authEntity = new MemberAuth(memberRequest.getAuth(), memberEntity);

        memberAuthRepository.save(authEntity);
    }

    @Transactional
    @Override
    public MemberRequest login(MemberRequest memberRequest) {
        Optional<Member> maybeMember = memberRepository.findByUserId(memberRequest.getId());

        if(maybeMember == null) {
            log.info("no Id");
            return null;
        }

        Member loginMember = maybeMember.get();

        if(!passwordEncoder.matches(memberRequest.getPw(), loginMember.getPassword())) {
            log.info("wrong password");
            return null;
        }

        Optional<MemberAuth> maybeMemberAuth =
                memberAuthRepository.findByMemberNo(loginMember.getMemberNo());

        if(maybeMemberAuth == null) {
            log.info("no auth");
            return null;
        }

        MemberAuth memberAuth = maybeMemberAuth.get();

        MemberRequest response = new MemberRequest(
                memberRequest.getId(),
                null,
                memberAuth.getAuth());

        return response;


    }


}
