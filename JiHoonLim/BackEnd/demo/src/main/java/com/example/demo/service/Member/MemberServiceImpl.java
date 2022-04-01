package com.example.demo.service.Member;

import com.example.demo.controller.Member.request.MemberRequest;
import com.example.demo.entity.Member.Member;
import com.example.demo.entity.Member.MemberAuth;
import com.example.demo.repository.Member.MemberAuthRepository;
import com.example.demo.repository.Member.MemberRepository;
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
    private MemberAuthRepository memberAuthRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(MemberRequest memberRequest) {
        String encodedPassword = passwordEncoder.encode(memberRequest.getPw());
        memberRequest.setPw(encodedPassword);

        MemberAuth authEntity = new MemberAuth(memberRequest.getAuth());
        Member memberEntity = new Member(memberRequest.getId(), memberRequest.getPw(), memberRequest.getNickName(),
                memberRequest.getEmail());

        memberEntity.addAuth(authEntity);

        memberRepository.save(memberEntity);

    }
}
