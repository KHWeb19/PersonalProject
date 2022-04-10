package com.example.demo.service.presonalProject;

import com.example.demo.controller.request.MemberRequest;
import com.example.demo.entity.personalProject.Member;
import com.example.demo.repository.personalProject.MemberRepository;
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
    public void register(Member member) {

        String encodedPassword = passwordEncoder.encode(member.getPw());
        member.setPw(encodedPassword);


        memberRepository.save(member);
    }

    @Override
    public Boolean login(MemberRequest memberRequest) {
        Optional<Member> maybeMember = memberRepository.findByUserId(memberRequest.getId());

        if(maybeMember == null) {
            log.info("Please enter correct id");
            return false;
        }

        Member loginMember = maybeMember.get();

        if(!passwordEncoder.matches(memberRequest.getPw(), loginMember.getPw())) {
            log.info("Please enter correct password");
            return false;
        }

        return true;

    }
}
