package com.example.demo.service.presonalProject;

import com.example.demo.controller.request.MemberDto;
import com.example.demo.entity.personalProject.Member;
import com.example.demo.repository.personalProject.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.GenericDeclaration;
import java.util.Optional;

@Slf4j
@Service
@Lazy
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Member register(MemberDto memberDto) throws Exception {
        String encodedPassword = passwordEncoder.encode(memberDto.getPw());
        memberDto.setPw(encodedPassword);

        Member member = memberRepository.save(memberDto.toEntity());

        return member;
    }

    @Override
    public boolean login(Member member) throws Exception {
        Optional<Member> maybeMember = memberRepository.findById(member.getId());

        if(maybeMember.isPresent()) {
            log.info("Find id");

            Member loginMember = maybeMember.get();

            if(!passwordEncoder.matches(member.getPw(), loginMember.getPw())){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean validationId(String id) throws Exception {
        Optional<Member> maybeMember = memberRepository.findById(id);

        if(!maybeMember.isPresent()) {
            log.info("Cannot find id");

            return false;
        }
        return true;
    }

    @Override
    public Optional<Member> userInfo(String id) throws Exception {
        return memberRepository.findById(id);
    }

    @Override
    public Member findById(String id) throws Exception {
        Member member = memberRepository.findById(id).orElseThrow();

        return member;
    }

    @Override
    public void modify(Member member, MemberDto memberDto) throws Exception {
        String encodedPassword = passwordEncoder.encode(memberDto.getPw());
        memberDto.setPw(encodedPassword);

        member.updateMember(memberDto);

        memberRepository.save(member);
    }

    @Override
    public void remove(Member member) throws Exception {
//        memberRepository.delete(member);
    }
}
