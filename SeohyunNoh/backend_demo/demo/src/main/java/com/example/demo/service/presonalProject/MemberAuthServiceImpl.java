package com.example.demo.service.presonalProject;

import com.example.demo.controller.request.MemberRequest;
import com.example.demo.entity.personalProject.MemberAuth;
import com.example.demo.entity.personalProject.MemberWithAuth;
import com.example.demo.repository.personalProject.MemberAuthCheckRepository;
import com.example.demo.repository.personalProject.MemberWithAuthRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MemberAuthServiceImpl implements MemberAuthService {

    @Autowired
    private MemberWithAuthRepository withAuthRepository;

    @Autowired
    private MemberAuthCheckRepository authCheckRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(MemberRequest memberRequest) {
        String encodedPassword = passwordEncoder.encode(memberRequest.getPw());
        memberRequest.setPw(encodedPassword);

        MemberAuth authEntity = new MemberAuth(memberRequest.getAuth());
        MemberWithAuth memberEntity = new MemberWithAuth(
                memberRequest.getId(), memberRequest.getPw());

        memberEntity.addAuth(authEntity);

        withAuthRepository.save(memberEntity);
    }
}
