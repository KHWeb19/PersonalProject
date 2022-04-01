package com.example.demo.service.member;

import com.example.demo.controller.member.request.MemberRequest;
import com.example.demo.entitiy.member.Member;
import com.example.demo.repository.member.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(MemberRequest memberRequest) {
            String encodedPassword = passwordEncoder.encode(memberRequest.getPassword());
            memberRequest.setPassword(encodedPassword);

            Member memberEntity = new Member(memberRequest.getUserId(), memberRequest.getPassword(),
                    memberRequest.getNickname(),memberRequest.getEmail());

            memberRepository.save(memberEntity);
        }

    @Override
    public List<Member> list()  {
        //현재 password가 암호화 되어있긴한데 이것도 같이 나감
       return memberRepository.findAll();

    }

    @Override
    public MemberRequest login(MemberRequest memberRequest) {
            Optional<Member> maybeMember = memberRepository.findByUserId(memberRequest.getUserId());

            if(maybeMember.equals(Optional.empty())){
                log.info("There are no person who has this id!");
                return null;
            }

            Member loginMember =maybeMember.get();

            if(!passwordEncoder.matches(memberRequest.getPassword(), loginMember.getPassword())) {
                log.info("Entered wrong password!");
                return null;
            }

            MemberRequest response = new MemberRequest(loginMember.getUserId(), null,
                    loginMember.getNickname(), loginMember.getEmail() );

            return response;
    }

    @Override
    public void modify(Member member) {
           String encodedPassword = passwordEncoder.encode(member.getPassword());
           member.setPassword(encodedPassword);

            memberRepository.save(member);
    }

    @Override
    public void remove(Member member) {
            log.info("memberNo" + member.getMemberNo() );
            memberRepository.deleteById(member.getMemberNo());
    }
}
