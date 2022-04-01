package com.example.backend.service;

import com.example.backend.controller.MemberRequest;
import com.example.backend.entity.Member;
import com.example.backend.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(MemberRequest memberRequest) {
        String encodedPassword = passwordEncoder.encode(memberRequest.getPw());
        memberRequest.setPw(encodedPassword);

        Member memberEntity = new Member(memberRequest.getName(), memberRequest.getId(), memberRequest.getPw());

        memberRepository.save(memberEntity);
    }

    @Override
    public MemberRequest login(MemberRequest memberRequest) {
        Optional<Member> maybeMember = memberRepository.findByUserId(memberRequest.getId());

        if (maybeMember.equals(Optional.empty())) {
            log.info("이런 사람 없다!");
            return null;
        }

        Member loginMember = maybeMember.get();

        if (!passwordEncoder.matches(memberRequest.getPw(), loginMember.getPassword())) {
            log.info("비밀번호를 잘못 입력했습니다!");
            return null;
        }

        MemberRequest response = new MemberRequest(
                memberRequest.getName(),
                memberRequest.getId(),
                null);

        return response;
    }
}
