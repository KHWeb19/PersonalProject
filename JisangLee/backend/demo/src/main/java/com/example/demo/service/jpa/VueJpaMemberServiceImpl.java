package com.example.demo.service.jpa;

import com.example.demo.controller.jpa.request.MemberRequest;
import com.example.demo.entity.jpa.VueJpaMember;

import com.example.demo.repository.jpa.VueJpaMemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Slf4j
@Service
public class VueJpaMemberServiceImpl implements VueJpaMemberService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private VueJpaMemberRepository memberRepository;

    @Override
    public void register(VueJpaMember member) {
        String encodedPassword = passwordEncoder.encode(member.getPw());
        member.setPw(encodedPassword);

        memberRepository.save(member);

    }

    @Override
    public MemberRequest login(MemberRequest memberRequest) {
        Optional<VueJpaMember> maybeMember = memberRepository.findByUserId(memberRequest.getId());
        if (maybeMember == null) {
            log.info("There are no person who has this id!");
            return null;
        }

        VueJpaMember loginMember = maybeMember.get();

        if (!passwordEncoder.matches(memberRequest.getPw(), loginMember.getPw())) {
            log.info("Entered wrong password!");
            return null;
        }


        if (loginMember.getId().equals(memberRequest.getId())) {
            memberRequest.setNickname(loginMember.getNickname());
            memberRequest.setAuth(loginMember.getAuth());
        }

        MemberRequest response = new MemberRequest(memberRequest.getNickname(), memberRequest.getAuth());
        return memberRequest;

    }

    @Transactional
    @Override
    public Boolean checkUserIdValidation(String id) {
        Optional<VueJpaMember> maybeMember = memberRepository.findByUserId(id);

        if (maybeMember.isPresent()) {
            return false;
        } else {
            return true;
        }
    }

    @Transactional
    @Override
    public Boolean checkUserNicknameValidation(String nickname) {
        Optional<VueJpaMember> maybeMember = memberRepository.findByUserNickname(nickname);
        if (maybeMember.isPresent()) {
            return false;
        } else {
            return true;
        }
    }

    @Transactional
    @Override
    public void register(MemberRequest memberRequest) {

        Optional<VueJpaMember> maybeMember = memberRepository.findByUserId(memberRequest.getId());

        VueJpaMember loginMember = maybeMember.get();

        if (loginMember.getAuth() != memberRequest.getAuth()) {
            loginMember.setAuth(memberRequest.getAuth());
        }
    }
}






