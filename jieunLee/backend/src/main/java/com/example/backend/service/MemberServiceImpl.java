package com.example.backend.service;

import com.example.backend.controller.MemberRequest;
import com.example.backend.entity.Member;
import com.example.backend.entity.MemberAuth;
import com.example.backend.repository.MemberAuthRepository;
import com.example.backend.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
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
        String encodedPassword = passwordEncoder.encode(memberRequest.getPw());
        memberRequest.setPw(encodedPassword);

        Member memberEntity = new Member(
                memberRequest.getName(), memberRequest.getId(), memberRequest.getPw());


        memberRepository.save(memberEntity);

        MemberAuth authEntity = new MemberAuth(memberRequest.getAuth(), memberEntity);

        memberAuthRepository.save(authEntity);
    }

    @Override
    public MemberRequest login(MemberRequest memberRequest) {
        //gitId가 레퍼지토리에 존재하는지 확인해서 정보를 maybe에 저장, 없으면 null
        Optional<Member> maybeMember = memberRepository.findByUserId(memberRequest.getId());

        if (maybeMember.equals(Optional.empty())) {
            log.info("이런 사람 없다!");
            return null;
        }

        //있으면 로그인멤버에 정보저장
        Member loginMember = maybeMember.get();

        //사용자가 입력한 비밀번호를 암호화하여 db에 저장된 암호와 비교
        if (!passwordEncoder.matches(memberRequest.getPw(), loginMember.getPassword())) {
            log.info("비밀번호를 잘못 입력했습니다!");
            return null;
        }

        Optional<MemberAuth> maybeMemberAuth =
                memberAuthRepository.findByMemberNo(loginMember.getMemberNo());

        if (maybeMemberAuth == null) {
            log.info("auth 없음");
            return null;
        }

        MemberAuth memberAuth = maybeMemberAuth.get();
        MemberRequest response = new MemberRequest(
                memberRequest.getName(),
                memberRequest.getId(),
                null,
                memberAuth.getAuth());

        return response;
    }

    @Override
    public List<Member> findBusiness() {
        List<Member> businessMember = memberRepository.selectMemberWithRole("관리자");
        return businessMember;
    }
}
