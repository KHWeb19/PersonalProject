package com.example.demo.service.presonalProject;

import com.example.demo.controller.request.MemberRequest;
import com.example.demo.entity.personalProject.MemberAuth;
import com.example.demo.entity.personalProject.MemberAuthCheckId;
import com.example.demo.repository.personalProject.MemberAuthCheckIdRepository;
import com.example.demo.repository.personalProject.MemberAuthRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class MemberAuthServiceImpl implements MemberAuthService{

    @Autowired
    private MemberAuthRepository memberAuthRepository;

    @Autowired
    private MemberAuthCheckIdRepository memberAuthCheckIdRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(MemberRequest memberRequest) {
        String encodedPassword = passwordEncoder.encode(memberRequest.getPw());
        memberRequest.setPw(encodedPassword);

        MemberAuth authEntity = new MemberAuth(memberRequest.getAuth());
        MemberAuthCheckId memberEntity = new MemberAuthCheckId(
                memberRequest.getId(), memberRequest.getPw()
        );

        memberEntity.addAuth(authEntity);

        memberAuthCheckIdRepository.save(memberEntity);
    }

    @Override
    public MemberRequest login(MemberRequest memberRequest) {
        Optional<MemberAuthCheckId> maybeMember = memberAuthCheckIdRepository.findByUserId(memberRequest.getId());

        if (maybeMember == null) {
            log.info("There are no person who has this id!");
            return null;
        }

        MemberAuthCheckId loginMember = maybeMember.get();

        if (!passwordEncoder.matches(memberRequest.getPw(), loginMember.getPassword())) {
            log.info("Entered wrong password!");
            return null;
        }

        Optional<MemberAuth> maybeMemberAuth =
                memberAuthRepository.findByMemberNo(loginMember.getMemberNo());

        if (maybeMemberAuth == null) {
            log.info("no auth");
            return null;
        }

        MemberAuth memberAuth = maybeMemberAuth.get();
        MemberRequest response = new MemberRequest(
                memberRequest.getId(),
                null,
                memberAuth.getAuth());

        return response;
    }
}
