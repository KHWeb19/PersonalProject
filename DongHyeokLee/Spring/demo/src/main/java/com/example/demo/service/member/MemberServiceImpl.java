package com.example.demo.service.member;

import com.example.demo.controller.member.request.MemberRequest;
import com.example.demo.entitiy.member.Member;
import com.example.demo.repository.member.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public void register(MemberRequest memberRequest) {


        Member memberEntity = new Member(memberRequest.getUserId(), memberRequest.getPassword(),
                memberRequest.getNickname(),memberRequest.getEmail());

        memberRepository.save(memberEntity);

    }

    @Override
    public List<Member> list()  {

        return memberRepository.findAll();
    }
}
