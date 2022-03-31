package com.example.demo.service.join;

import com.example.demo.entity.Member;
import com.example.demo.repository.JoinMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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

}
