package com.example.demo.service;

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
        log.info("register() " + memberRequest);
        String encodedPassword = passwordEncoder.encode(memberRequest.getPw());
        memberRequest.setPw(encodedPassword);
        Member memberEntity = new Member(
                memberRequest.getId(), memberRequest.getSn() , memberRequest.getPw(), memberRequest.getPwConfirm()
        );

        memberRepository.save(memberEntity);
    }

    @Override
    public MemberRequest login(MemberRequest memberRequest) {
        Optional<Member> maybeMember = memberRepository.findByUserId(memberRequest.getId());

        if(maybeMember.equals(Optional.empty())){
            log.info("There are no person who has this id!");
            return null;
        }

        Member loginMember =maybeMember.get();

        if(!passwordEncoder.matches(memberRequest.getPw(), loginMember.getPassword())) {
            log.info("Entered wrong password!");
            return null;
        }

        /*
        // 로그인 하는 순간 해당 회원의 멤버번호 가져오기
        if (loginMember.getUserId().equals(memberRequest.getId())) {

            memberRequest.setMemberNo(loginMember.getMemberNo());
            memberRequest.setSn(loginMember.getStoreName());
        }
        */

        MemberRequest response = new MemberRequest(
                loginMember.getMemberNo(), loginMember.getUserId(), loginMember.getStoreName(), null,
                loginMember.getPasswordQAnswer() );

        return response;
    }

    @Override
    public Member read(Long memberNo) {
        Optional<Member> getMemberInfo = memberRepository.findById(Long.valueOf(memberNo));

        return getMemberInfo.get();
    }

    /*
        @Override
    public void modify(JpaBoard board) {
        repository.save(board);
    }

    @Override
    public void remove(Integer boardNo) {
        repository.deleteById(Long.valueOf(boardNo));
    }
     */
}
