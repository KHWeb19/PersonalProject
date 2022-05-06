package com.example.backend.service.member;

import com.example.backend.entity.Member;
import com.example.backend.entity.MemberAuth;
import com.example.backend.repository.member.MemberAuthRepository;
import com.example.backend.repository.member.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class MemberManagerServiceImpl implements MemberManagerService{

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
            log.info("can't read memberRead");
            return null;
        }
        return maybeMember.get();
    }

    @Override
    public MemberAuth memberAuthRead(Long memberNo) {
        Optional<MemberAuth> maybeMemberAuth = memberAuthRepository.findByMemberNo(memberNo);

        if (maybeMemberAuth.equals(Optional.empty())){
            log.info("can't read memberAuthRead");
            return null;
        }
        return maybeMemberAuth.get();
    }

    @Override
    public void modify(MemberAuth memberAuth) {
        memberAuthRepository.save(memberAuth);
    }

    @Override
    public void remove(Long memberNo) {
        memberRepository.deleteById(memberNo);
    }

}
