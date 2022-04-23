package com.example.demo.service.user;


import com.example.demo.entity.user.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.request.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Lazy
@Slf4j
public class MemberServiceImpl implements MemberService {
    @Autowired
    private MemberRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Member signup(MemberDto memberDto) throws Exception {
        String encodedPassword = passwordEncoder.encode(memberDto.getPw());
        memberDto.setPw(encodedPassword);

        Member member = repository.save(memberDto.toEntity());

        return member;
    }

    @Override
    public boolean login(Member member) throws Exception {
        Optional<Member> maybeMember = repository.findById(member.getId());

        if (maybeMember.isPresent()) {
            log.info("Find Id");

            Member loginMember = maybeMember.get();

            if(!passwordEncoder.matches(member.getPw(), loginMember.getPw())) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean validationId(String id) throws Exception {
        Optional<Member> maybeMember = repository.findById(id);

        if (!maybeMember.isPresent()) {
            log.info("Not Find Id");

            return false;
        }

        return true;
    }
}












