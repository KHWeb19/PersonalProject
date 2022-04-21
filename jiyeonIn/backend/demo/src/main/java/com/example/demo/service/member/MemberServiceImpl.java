package com.example.demo.service.member;

import com.example.demo.controller.memberController.Response.ManagerResponse;
import com.example.demo.controller.memberController.Response.MemberResponse;
import com.example.demo.controller.memberController.request.MemberRequest;
import com.example.demo.entity.member.Member;
import com.example.demo.entity.member.MemberAuth;
import com.example.demo.repository.MemberAuthRepository;
import com.example.demo.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
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
    public void modify(MemberResponse member) {
        log.info("modify member info:" +member);

        Optional<Member> maybeMember = memberRepository.findByUserId(member.getUserId());
        Member loginMember = maybeMember.get();
        log.info("before member info:" +loginMember);

        Member memberEntity;

        if(member.getPassword().equals("no")){
            memberEntity = new Member(
                    loginMember.getMemberNo(),member.getUserId(), loginMember.getPassword(),member.getUserName(),loginMember.getRegDate());

            memberRepository.save(memberEntity);
        }else {
            String encodedPassword = passwordEncoder.encode(member.getPassword());
            memberEntity = new Member(
                    loginMember.getMemberNo(),member.getUserId(), encodedPassword,member.getUserName(),loginMember.getRegDate());

            memberRepository.save(memberEntity);
        }

        Optional<MemberAuth> maybeMemberAuth =
                memberAuthRepository.findByMemberNo(loginMember.getMemberNo());

    }

    @Transactional
    @Override
    public void remove(String id) {
        Optional<Member> maybeMember = memberRepository.findByUserId(id);
        Member loginMember = maybeMember.get();
        log.info("before member info:" +loginMember);

        memberRepository.deleteById(loginMember.getMemberNo());

    }

    @Transactional
    @Override
    public List<Member> list() {
        return memberRepository.findAll(Sort.by(Sort.Direction.DESC,"memberNo"));
    }


}
