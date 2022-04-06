package com.example.demo.service;

import com.example.demo.controller.request.MemberRequest;
import com.example.demo.entity.JpaMemberEntity;
import com.example.demo.repository.JpaMemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class JpaMemberServiceImpl implements JpaMemberService {

    @Autowired
    private JpaMemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(MemberRequest memberRequest) {
        String encodedPassword = passwordEncoder.encode(memberRequest.getPw());
        memberRequest.setPw(encodedPassword);

        JpaMemberEntity memberEntity = new JpaMemberEntity(
                memberRequest.getId(), memberRequest.getSn() , memberRequest.getPw(), memberRequest.getPwConfirm()
        );

        memberRepository.save(memberEntity);
    }
}
