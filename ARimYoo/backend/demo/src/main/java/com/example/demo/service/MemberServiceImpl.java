package com.example.demo.service;

import com.example.demo.controller.Request.MemberRequest;
import com.example.demo.entity.Member;
import com.example.demo.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(Member member) {

        String encodedPassword = passwordEncoder.encode(member.getPw());
        member.setPw(encodedPassword);

        repository.save(member);
    }

    @Override
    public Boolean checkId(String id) {
        Optional<Member> checkId = repository.findByUserId(id);

        if (checkId.isPresent()){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public MemberRequest login(MemberRequest memberRequest) {
        Optional<Member> maybeMember = repository.findByUserId(memberRequest.getId());

        if (maybeMember.equals(Optional.empty())) {
            log.info("Id값이 없습니다.");
            return null;
        }

        Member loginMember = maybeMember.get();

        if (!passwordEncoder.matches(memberRequest.getPw(), loginMember.getPw())) {
            log.info("Entered wrong password!");
            return null;
        }
        // 로그인 하는 순간 해당 회원의 멤버번호 가져오기

            memberRequest.setMemberNo(loginMember.getMemberNo());
            memberRequest.setName(loginMember.getName());
            memberRequest.setBirth(loginMember.getBirth());
            memberRequest.setIntro(loginMember.getIntro());
            memberRequest.setProfilePic(loginMember.getProfilePic());

            log.info("check" + memberRequest.getBirth());
            log.info("check" + memberRequest.getIntro());
            MemberRequest response = new MemberRequest(memberRequest.getMemberNo(), memberRequest.getId(), null,
                memberRequest.getName(),memberRequest.getBirth(), memberRequest.getIntro(), memberRequest.getProfilePic());

            return response;
    }

    @Override
    public Member read(Long memberNo) {
        Optional<Member> getMemberInfo = repository.findById(Long.valueOf(memberNo));

        return getMemberInfo.get();
    }

    @Override
    public void modify(Member member, @RequestParam(required = false) MultipartFile file) throws Exception {

        String encodedPassword = passwordEncoder.encode(member.getPw());
        member.setPw(encodedPassword);

        if (file != null) {

            UUID uuid = UUID.randomUUID();
            String fileName = uuid + "_" + file.getOriginalFilename();
            FileOutputStream saveFile = new FileOutputStream("../../frontend/src/assets/back/member/" + fileName);

            saveFile.write(file.getBytes());
            saveFile.close();

            member.setProfilePic(fileName);
        }

        repository.save(member);
    }

    @Override
    public void remove(Long memberNo) {
        repository.deleteById(Long.valueOf(memberNo));
    }
}



