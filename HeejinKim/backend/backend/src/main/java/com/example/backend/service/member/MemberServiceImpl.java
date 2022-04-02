package com.example.backend.service.member;

import com.example.backend.controller.member.request.MemberRequest;
import com.example.backend.entity.Member;
import com.example.backend.entity.MemberAuth;
import com.example.backend.repository.member.MemberAuthRepository;
import com.example.backend.repository.member.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberAuthRepository memberAuthRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void register(MemberRequest memberRequest) {

        //비밀번호 암호화화
       String encodedPassword = passwordEncoder.encode(memberRequest.getPassword());
        memberRequest.setPassword(encodedPassword);

        String encodedPasswordCheck = passwordEncoder.encode(memberRequest.getPasswordCheck());
        memberRequest.setPasswordCheck(encodedPasswordCheck);


        //Member 엔티티에 memberRequest 안에 값들을 vue에서 받아온 값 넣어줌
        Member memberEntity = new Member( memberRequest.getUserId(),memberRequest.getPassword(), memberRequest.getPasswordCheck(), memberRequest.getEmail());

        memberRepository.save(memberEntity);

        MemberAuth authEntity = new MemberAuth( memberRequest.getAuth(), memberEntity);

        memberAuthRepository.save(authEntity);

    }

    @Transactional
    @Override
    public MemberRequest login(MemberRequest memberRequest) {

        //로그인시 아이디 확인
        Optional<Member> maybeMember = memberRepository.findByUserId(memberRequest.getUserId());

        if(maybeMember.equals(Optional.empty())){
            log.info("There are no person who has this id!");
            return null;
        }
        Member loginMember = maybeMember.get();

        if (!passwordEncoder.matches(memberRequest.getPassword(), loginMember.getPassword())) {
            log.info("Entered wrong password!");
            return null;
        }

        //권한 매칭
        Optional<MemberAuth> maybeMemberAuth =
                memberAuthRepository.findByMemberNo(loginMember.getMemberNo());

        if (maybeMemberAuth.equals(Optional.empty())) {
            log.info("no auth");
            return null;
        }

        MemberAuth memberAuth = maybeMemberAuth.get();

        MemberRequest response = new MemberRequest( memberRequest.getUserId(),null,  memberAuth.getAuth());

        return response;
    }

    @Transactional
    @Override
    public Boolean checkUserIdValidation(String userId) {
        Optional<Member> maybeMember = memberRepository.findByUserId(userId);

        if(maybeMember.isPresent()) {
            log.info("login(): there is no id");
            return false;
        }

        else {
            return true;
        }
    }

}
