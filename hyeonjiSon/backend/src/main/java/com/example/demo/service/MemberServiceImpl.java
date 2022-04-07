package com.example.demo.service;

import com.example.demo.controller.request.MemberRequest;
import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(MemberRequest memberRequest) {
        log.info("register() " + memberRequest);
        String encodedPassword = passwordEncoder.encode(memberRequest.getPw());
        memberRequest.setPw(encodedPassword);

        Member memberEntity = new Member(
                memberRequest.getId(), memberRequest.getSn() , memberRequest.getPw(), memberRequest.getPwConfirm()
        );

        memberRepository.save(memberEntity);
    }
}
