package com.example.demo.service.Member;

import com.example.demo.entity.Member.Member;
import com.example.demo.entity.Member.MemberAuth;
import com.example.demo.repository.Member.MemberAuthRepository;
import com.example.demo.repository.Member.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class MemberManageServiceImpl implements MemberManageService{

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberAuthRepository memberAuthRepository;


    @Override
    public List<Member> list() {
        return memberRepository.findAll(Sort.by(Sort.Direction.DESC,"memberNo"));
    }

    @Override
    public List<MemberAuth> authList() {
        return memberAuthRepository.findAll(Sort.by(Sort.Direction.DESC,"memberNo"));
    }

    @Override
    public Member memberRead(Long memberNo) {
        Optional<Member> maybeMember = memberRepository.findById(memberNo);

        if (maybeMember.equals(Optional.empty())){
            log.info("No info");
            return null;
        }
        return maybeMember.get();
    }

    @Override
    public MemberAuth memberAuthRead(Long memberNo) {
        Optional<MemberAuth> maybeMemberAuth = memberAuthRepository.findByMemberNo(memberNo);

        if (maybeMemberAuth.equals(Optional.empty())){
            log.info("No info");
            return null;
        }
        return maybeMemberAuth.get();
    }
}
