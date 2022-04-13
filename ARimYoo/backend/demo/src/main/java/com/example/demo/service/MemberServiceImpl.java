package com.example.demo.service;

import com.example.demo.controller.Request.MemberRequest;
import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(Member member) {

        String encodedPassword = passwordEncoder.encode(member.getPw());
        member.setPw(encodedPassword);

        repository.save(member);
    }

    @Override
    public MemberRequest login(MemberRequest memberRequest) {
        Optional<Member> maybeMember = repository.findByUserId(memberRequest.getId());

        if (maybeMember.equals(Optional.empty())) {
            log.info("Id값이 없습니다.");
            return null;
        }

        Member loginMember = maybeMember.get();

        if (!passwordEncoder.matches(memberRequest.getPw(), loginMember.getPw())) {
            log.info("Entered wrong password!");
            return null;
        }

        MemberRequest response = new MemberRequest(
                memberRequest.getId(),
                null);

        return response;
    }

}


