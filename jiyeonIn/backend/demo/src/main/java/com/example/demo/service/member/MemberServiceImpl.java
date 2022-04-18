package com.example.demo.service.member;

import com.example.demo.controller.memberController.request.MemberRequest;
import com.example.demo.entity.member.Member;
import com.example.demo.entity.member.MemberAuth;
import com.example.demo.repository.MemberAuthRepository;
import com.example.demo.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberAuthRepository memberAuthRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Transactional
    @Override
    public void register(MemberRequest memberRequest) {
        String encodedPassword = passwordEncoder.encode(memberRequest.getPw());
        memberRequest.setPw(encodedPassword);

        Member memberEntity = new Member(
                memberRequest.getId(), memberRequest.getPw(),memberRequest.getName());

        memberRepository.save(memberEntity);

        MemberAuth authEntity = new MemberAuth(memberRequest.getAuth(), memberEntity);

        memberAuthRepository.save(authEntity);
    }

    @Transactional
    @Override
    public MemberRequest login(MemberRequest memberRequest) {
        Optional<Member> maybeMember = memberRepository.findByUserId(memberRequest.getId());

        if(maybeMember.equals(Optional.empty())) {
            log.info("no Id");
            return null;
        }

        Member loginMember = maybeMember.get();

        if(!passwordEncoder.matches(memberRequest.getPw(), loginMember.getPassword())) {
            log.info("wrong password");
            return null;
        }

        Optional<MemberAuth> maybeMemberAuth =
                memberAuthRepository.findByMemberNo(loginMember.getMemberNo());

        if(maybeMemberAuth == null) {
            log.info("no auth");
            return null;
        }

        MemberAuth memberAuth = maybeMemberAuth.get();

        MemberRequest response = new MemberRequest(
                memberRequest.getId(),
                null,
                memberRequest.getName(),
                memberAuth.getAuth());

        return response;
    }

    @Transactional
    @Override
    public Boolean checkUserIdValidation(String userId) {
        Optional<Member> maybeMember = memberRepository.findByUserId(userId);

        if(maybeMember.isPresent()) {
            return false;
        }else {
            return true;
        }
    }

    @Transactional
    @Override
    public MemberRequest read(String id) {

        Optional<Member> maybeMember = memberRepository.findByUserId(id);


        Member loginMember = maybeMember.get();

        Optional<MemberAuth> maybeMemberAuth =
                memberAuthRepository.findByMemberNo(loginMember.getMemberNo());


        MemberAuth memberAuth = maybeMemberAuth.get();

        MemberRequest response = new MemberRequest(
                id,
                null,
                loginMember.getUserName(),
                memberAuth.getAuth());

        log.info("info:" + response);
        return response;

    }

    /*
        1. 멤버 넘버 member에 넣기
        2. 패스워드가 0이면 기존의 아이디로 넣기
     */
    @Transactional
    @Override
    public void modify(Member member) {
        log.info("modify member info:" +member);

        Optional<Member> maybeMember = memberRepository.findByUserId(member.getUserId());
        Member loginMember = maybeMember.get();
        log.info("current member info:" +loginMember);

        member.setMemberNo(loginMember.getMemberNo());
        member.setRegDate(loginMember.getRegDate());

        if(member.getPassword().equals("0")){
            member.setPassword(loginMember.getPassword());
        }else {
            String encodedPassword = passwordEncoder.encode(member.getPassword());
            member.setPassword(encodedPassword);
        }

        log.info("final member info:" +member);
        memberRepository.save(member);

        Optional<MemberAuth> maybeMemberAuth =
                memberAuthRepository.findByMemberNo(member.getMemberNo());

        MemberAuth memberAuth = maybeMemberAuth.get();


        MemberAuth authEntity = new MemberAuth(memberAuth.getAuth(), member);

        memberAuthRepository.save(authEntity);

    }


}
