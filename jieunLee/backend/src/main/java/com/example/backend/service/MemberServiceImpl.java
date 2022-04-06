package com.example.backend.service;

import com.example.backend.controller.MemberRequest;
import com.example.backend.entity.Member;
import com.example.backend.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Member> list() {
        return memberRepository.findAll(Sort.by(Sort.Direction.DESC, "memberNo"));
    }


    @Override
    public void register(MemberRequest memberRequest) {
        String encodedPassword = passwordEncoder.encode(memberRequest.getPassword());
        memberRequest.setPassword(encodedPassword);

        Member memberEntity = new Member(
                memberRequest.getMemberNo(),
                memberRequest.getMemberName(),
                memberRequest.getMemberId(),
                memberRequest.getPassword(),
                memberRequest.getMemberWeb(),
                memberRequest.getMemberIntro()
        );

        memberRepository.save(memberEntity);
    }

    @Override
    public MemberRequest login(MemberRequest memberRequest) {
        Optional<Member> maybeMember = memberRepository.findByUserId(memberRequest.getMemberId());

        if (maybeMember.equals(Optional.empty())) {
            log.info("이런 사람 없다!");
            return null;
        }

        Member loginMember = maybeMember.get();

        if (!passwordEncoder.matches(memberRequest.getPassword(), loginMember.getPassword())) {
            log.info("비밀번호를 잘못 입력했습니다!");
            return null;
        }

        if (loginMember.getMemberId().equals(memberRequest.getMemberId())) {

            memberRequest.setMemberNo(loginMember.getMemberNo());
            memberRequest.setMemberName(loginMember.getMemberName());
            memberRequest.setMemberId(loginMember.getMemberId());
            memberRequest.setPassword(loginMember.getPassword());
            memberRequest.setMemberWeb(loginMember.getMemberWeb());
            memberRequest.setMemberIntro(loginMember.getMemberIntro());
            memberRequest.setRegData(loginMember.getRegDate());
        }

        MemberRequest response = new MemberRequest(
                memberRequest.getMemberNo(),
                memberRequest.getMemberName(),
                memberRequest.getMemberId(),
                null,
                memberRequest.getMemberWeb(),
                memberRequest.getMemberIntro(),
                memberRequest.getRegData());

        return response;
    }

    @Override
    public Member read(Long memberNo) {
        Optional<Member> maybeReadMember = memberRepository.findById(Long.valueOf(memberNo));

        if (maybeReadMember.equals(Optional.empty())) {

            return null;
        }

        return maybeReadMember.get();
    }

    @Override
    public void modify(Member member) {


        String encodedPassword = passwordEncoder.encode(member.getPassword());
        member.setPassword(encodedPassword);

        memberRepository.save(member);
    }
}
