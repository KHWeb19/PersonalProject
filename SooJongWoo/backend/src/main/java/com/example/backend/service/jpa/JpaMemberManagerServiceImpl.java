package com.example.backend.service.jpa;

import com.example.backend.entity.jpa.Member;
import com.example.backend.entity.jpa.MemberAuth;
import com.example.backend.repository.jpa.JpaMemberAuthRepository;
import com.example.backend.repository.jpa.JpaMemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class JpaMemberManagerServiceImpl implements JpaMemberManagerService {

    @Autowired
    private JpaMemberRepository memberRepository;

    @Autowired
    private JpaMemberAuthRepository memberAuthRepository;

    @Override
    public List<Member> list() throws Exception {
        return memberRepository.findAll();
    }

    @Override
    public Member read(Long memberNo) throws Exception {
        Optional<Member> memberDetail = memberRepository.findById(memberNo);
        if (memberDetail.isPresent()) {
            Member member = memberDetail.get();
            memberRepository.save(member);

            return member;
        } else {
            throw new NullPointerException();
        }

    }

    @Override
    public void remove(Long memberNo) throws Exception {
        memberRepository.deleteById(memberNo);
    }

    //auth
    public List<MemberAuth> authList() throws Exception {
        return memberAuthRepository.findAll();
    }
}