package com.example.demo.service.member;

import com.example.demo.controller.request.MemberRequest;
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
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public void register(MemberRequest memberRequest) {
        Optional<Member> check = memberRepository.findByUserId(memberRequest.getId());
        if (!check.equals(Optional.empty())) {
            log.info("이미 있는 아이디입니다");
        }
        else {
            String encodedPassword = passwordEncoder.encode(memberRequest.getPw());
            memberRequest.setPw(encodedPassword);
            Member memberEntity = new Member(memberRequest.getId(), memberRequest.getPw(), memberRequest.getName(),
                    memberRequest.getEmail());
            memberRepository.save(memberEntity);
        }


    }

    @Override
    public MemberRequest login(MemberRequest memberRequest) {
        Optional<Member> maybeMember = memberRepository.findByUserId(memberRequest.getId());

        if (maybeMember.equals(Optional.empty())) {
            log.info("There are no person who has this id!");
            return null;
        }

        Member loginMember = maybeMember.get();

        if (!passwordEncoder.matches(memberRequest.getPw(), loginMember.getPw())) {
            log.info("wrong password!");
            return null;
        }
        MemberRequest response = new MemberRequest(
                memberRequest.getId(),null, memberRequest.getName(), memberRequest.getEmail());

        return response;
    }


//
//    @Override
//    public Member read(Long memberNo) {
//        return memberRepository.getById(Long.valueOf(memberNo));
//    }
//
//    @Override
//    public void modify(Member member) {
//        memberRepository.save(member);
//    }
//
}
