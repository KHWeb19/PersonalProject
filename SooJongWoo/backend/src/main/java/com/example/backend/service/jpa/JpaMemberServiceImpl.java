package com.example.backend.service.jpa;

import com.example.backend.controller.member.request.MemberRequest;
import com.example.backend.entity.jpa.Member;
import com.example.backend.entity.jpa.MemberAuth;
import com.example.backend.repository.jpa.JpaMemberAuthRepository;
import com.example.backend.repository.jpa.JpaMemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Slf4j
@Service
public class JpaMemberServiceImpl implements JpaMemberService {

    @Autowired
    private JpaMemberRepository memberRepository;

    @Autowired
    private JpaMemberAuthRepository memberAuthRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(MemberRequest memberRequest) throws Exception {
        String encodedPassword = passwordEncoder.encode(memberRequest.getPassword());
        memberRequest.setPassword(encodedPassword);
        String encodedPasswordReInput = passwordEncoder.encode(memberRequest.getPasswordReInput());
        memberRequest.setPasswordReInput(encodedPasswordReInput);

        MemberAuth authEntity = new MemberAuth(memberRequest.getAuth());
        Member memberEntity = new Member(memberRequest.getUserId(), memberRequest.getPassword(),
                memberRequest.getPasswordReInput(),memberRequest.getUserName());
        memberEntity.addAuth(authEntity);

        memberRepository.save(memberEntity);

    }

    @Override
    public boolean duplicateCheck(MemberRequest memberRequest) throws Exception {
        Optional<Member> checkMember = memberRepository.findByDuplicateCheck(memberRequest.getUserId());
        if (checkMember.isPresent()) {
            log.info("already exist");
            return false;
        } else {
            return true;
        }
    }

}
