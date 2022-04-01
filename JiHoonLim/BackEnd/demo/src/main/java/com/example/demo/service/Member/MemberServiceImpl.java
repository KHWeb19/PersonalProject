package com.example.demo.service.Member;

import com.example.demo.controller.Member.request.MemberRequest;
import com.example.demo.entity.Member.Member;
import com.example.demo.entity.Member.MemberAuth;
import com.example.demo.repository.Member.MemberAuthRepository;
import com.example.demo.repository.Member.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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

    @Override
    public void register(MemberRequest memberRequest) {
        String encodedPassword = passwordEncoder.encode(memberRequest.getPw());
        memberRequest.setPw(encodedPassword);

        MemberAuth authEntity = new MemberAuth(memberRequest.getAuth());
        Member memberEntity = new Member(memberRequest.getId(), memberRequest.getPw(), memberRequest.getNickName(),
                memberRequest.getEmail());

        memberEntity.addAuth(authEntity);

        memberRepository.save(memberEntity);

    }

    @Override
    public MemberRequest login(MemberRequest memberRequest) {
        Optional<Member> maybeMember = memberRepository.findByUserId(memberRequest.getId());

        if (maybeMember == null){
            log.info("No Id");
            return null;
        }

        Member loginMember = maybeMember.get();

        if (!passwordEncoder.matches(memberRequest.getPw(), loginMember.getPw())) {
            log.info("Wrong Pw");
            return null;
        }

        MemberRequest response = new MemberRequest(
                memberRequest.getId(),null,memberRequest.getNickName(),memberRequest.getEmail(),memberRequest.getAuth());
        return response;
    }

    @Override
    public Boolean checkDuplicate(String id) {
        Optional<Member> checkDupId = memberRepository.findByUserId(id);

        if (checkDupId.isPresent()){
            return false;
        }else {
            return true;
        }
    }
}
