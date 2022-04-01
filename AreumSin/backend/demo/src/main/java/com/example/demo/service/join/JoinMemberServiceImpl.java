package com.example.demo.service.join;

import com.example.demo.entity.Member;
import com.example.demo.repository.JoinMemberRepository;
import com.example.demo.request.MemberRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class JoinMemberServiceImpl implements JoinMemberService{

    @Autowired
    private JoinMemberRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(Member member) {
        String encodePassword = passwordEncoder.encode(member.getPw());
        member.setPw(encodePassword);

        repository.save(member);
    }

    @Override
    public Boolean checkIdDuplicate(String id) {
        return repository.existsById(id);
    }

    @Override
    public MemberRequest login(MemberRequest memberRequest) {
        Optional<Member> maybeMember = repository.findById(memberRequest.getId()); //맞을 수도있고 아닐수도 있고

        if(maybeMember.equals(Optional.empty())){
            log.info("No id!");
            return new MemberRequest(null, null, null, null, false);
        }

        Member loginMember = maybeMember.get();

        if(!passwordEncoder.matches(memberRequest.getPw(), loginMember.getPw())){
            log.info("Wrong password!");
            return new MemberRequest(null, null, null, null, false);
        }

        MemberRequest response = new MemberRequest(memberRequest.getId(), null, null, null, true);

        return response;
    }

}
