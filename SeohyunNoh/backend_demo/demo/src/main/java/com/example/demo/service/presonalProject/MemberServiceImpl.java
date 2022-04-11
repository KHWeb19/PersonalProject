package com.example.demo.service.presonalProject;

import com.example.demo.entity.personalProject.Member;
import com.example.demo.repository.personalProject.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberRepository memberRepository;

    public void register (Member member) {
        member.setAuth(member.getAuth() == "개인" ? "개인" : member.getAuth() == "판매자" ? "판매자" : "관리자");

        memberRepository.save(member);
    }

    public Member login (String auth, String id, String pw) {
        Member memberVo = memberRepository.selectUserInfo(auth, id, pw);
        return memberVo;
    }


}
