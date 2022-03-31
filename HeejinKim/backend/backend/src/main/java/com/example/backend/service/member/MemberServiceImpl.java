package com.example.backend.service.member;

import com.example.backend.controller.member.request.MemberRequest;
import com.example.backend.entity.Member;
import com.example.backend.entity.MemberAuth;
import com.example.backend.repository.member.MemberAuthRepository;
import com.example.backend.repository.member.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberAuthRepository memberAuthRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void register(MemberRequest memberRequest) {

        //비밀번호 암호화화
       String encodedPassword = passwordEncoder.encode(memberRequest.getPassword());
        memberRequest.setPassword(encodedPassword);

        String encodedPasswordCheck = passwordEncoder.encode(memberRequest.getPasswordCheck());
        memberRequest.setPasswordCheck(encodedPasswordCheck);


        //Member 엔티티에 memberRequest 안에 값들을 vue에서 받아온 값 넣어줌
        Member memberEntity = new Member( memberRequest.getUserId(),memberRequest.getPassword(), memberRequest.getPasswordCheck(), memberRequest.getEmail());

        memberRepository.save(memberEntity);

        MemberAuth authEntity = new MemberAuth( memberRequest.getAuth(), memberEntity);

        memberAuthRepository.save(authEntity);

    }
}
