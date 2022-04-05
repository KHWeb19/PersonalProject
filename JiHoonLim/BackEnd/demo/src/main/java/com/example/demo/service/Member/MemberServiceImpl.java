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

    @Override
    public void register(MemberRequest memberRequest) {
        String encodedPassword = passwordEncoder.encode(memberRequest.getPw());
        memberRequest.setPw(encodedPassword);

        MemberAuth authEntity = new MemberAuth(memberRequest.getAuth());
        Member memberEntity = new Member(memberRequest.getId(), memberRequest.getPw(), memberRequest.getName() ,memberRequest.getNickName(),
                memberRequest.getEmail());

        memberEntity.addAuth(authEntity);

        memberRepository.save(memberEntity);

    }

    @Override
    public MemberRequest login(MemberRequest memberRequest) {
        Optional<Member> maybeMember = memberRepository.findByUserId(memberRequest.getId());

        if (maybeMember.equals(Optional.empty())){
            log.info("No Id");
            return null;
        }

        Member loginMember = maybeMember.get();

        if (!passwordEncoder.matches(memberRequest.getPw(), loginMember.getPw())) {
            log.info("Wrong Pw");
            return null;
        }

        MemberRequest response = new MemberRequest(
                memberRequest.getId(),null,memberRequest.getName() ,memberRequest.getNickName(),memberRequest.getEmail(),memberRequest.getAuth());
        return response;
    }

    @Override
    public Boolean checkDuplicateId(String id) {
        Optional<Member> checkDupId = memberRepository.findByUserId(id);

        if (checkDupId.isPresent()){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public Boolean checkDuplicateNickName(String nickName) {
        Optional<Member> checkDupNickName = memberRepository.findByUserNickName(nickName);

        if (checkDupNickName.isPresent()){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public Boolean checkDuplicateEmail(String email) {
        Optional<Member> checkDupEmail = memberRepository.findByUserEmail(email);

        if (checkDupEmail.isPresent()){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public List findUserId(String email) {

        return memberRepository.searchUserId(email);
    }

    @Override
    public Boolean idMatchEmail(MemberRequest memberRequest) {
        Optional<Member> maybeMember = memberRepository.findByUserId(memberRequest.getId());
        Member loginMember = maybeMember.get();

        String UserEmail = loginMember.getEmail();

        String MaybeEmail = memberRequest.getEmail();

        if (UserEmail.equals(MaybeEmail)){
            return true;
        }
        return false;
    }


}
