package com.example.demo.service.Member;

import com.example.demo.controller.request.MemberRequest;
import com.example.demo.entity.Member.Member;
import com.example.demo.entity.Member.MemberAuth;
import com.example.demo.repository.Member.MemberAuthRepository;
import com.example.demo.repository.Member.MemberRepository;
import com.example.demo.service.Member.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;  //엔티티 조회, 저장, 삭제

    @Autowired
    private MemberAuthRepository memberAuthRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void register (MemberRequest memberRequest) {
        //비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(memberRequest.getPassword());
        memberRequest.setPassword(encodedPassword);

        Member memberEntity = new Member(
                memberRequest.getId(), memberRequest.getPassword(), memberRequest.getName(), memberRequest.getBirth(),
                memberRequest.getPhone());

        memberRepository.save(memberEntity);

        MemberAuth authEntity = new MemberAuth(memberRequest.getAuth(), memberEntity);
        memberAuthRepository.save(authEntity);
    }

    @Override
    @Transactional
    public MemberRequest checkUserIdDuplication (MemberRequest memberRequest){
        Optional<Member> checkID = memberRepository.findById(memberRequest.getId());

        MemberRequest responseID = new MemberRequest(memberRequest.getId());

        if (checkID.equals(Optional.empty())) {
            log.info("사용가능한 아이디");
            return responseID;
        } else {
            log.info("아이디 중복");
            return null;
        }
    }

    @Transactional
    @Override
    public MemberRequest login (MemberRequest memberRequest) {
        Optional<Member> maybeMember = memberRepository.findById(memberRequest.getId());

        if(maybeMember.equals(Optional.empty())) {
            log.info("아이디 없음");
            return null;
        }

        Member loginMember = maybeMember.get();

        if(!passwordEncoder.matches(memberRequest.getPassword(), loginMember.getPassword())) {
            log.info("비밀번호 잘못 입력했습니다.");
            return null;
        }

        if(loginMember.getId().equals(memberRequest.getId())) {
            memberRequest.setMemberNo(loginMember.getMemberNo());
            memberRequest.setName(loginMember.getName());
            memberRequest.setBirth(loginMember.getBirth());
            memberRequest.setPhone(loginMember.getPhone());
        }

        MemberRequest response = new MemberRequest(
                memberRequest.getMemberNo(),
                memberRequest.getId(),
                memberRequest.getPassword(),
                memberRequest.getName(),
                memberRequest.getBirth(),
                memberRequest.getPhone()
                );

        return response;
    }

    @Override
    public List<Member> list () {
        return memberRepository.findAll(Sort.by(Sort.Direction.DESC, "memberNo"));
    }

    @Override
    public Member readPersonalInform (Long memberNo) {
        Optional<Member> maybeReadMember = memberRepository.readById(memberNo);

        if(maybeReadMember.equals(Optional.empty())) {
            log.info("Can not read Personal Information!");
            return null;
        }
        return maybeReadMember.get();
    }

    @Override
    public void modifyPersonalInform(Member member){

        String encodedPassword = passwordEncoder.encode(member.getPassword());
        member.setPassword(encodedPassword);
        memberRepository.save(member);
    }

    @Override
    public void remove (Long memberNo) {
        memberRepository.deleteById(Long.valueOf(memberNo));
    }
}
