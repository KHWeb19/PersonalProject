package com.example.demo.service.jpa;

import com.example.demo.entity.jpa.VueJpaMember;
import com.example.demo.repository.jpa.VueJpaMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class VueJpaMemberServiceImpl implements VueJpaMemberService {

    @Autowired
    private VueJpaMemberRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void register(VueJpaMember member) {
        String encodedPassword = passwordEncoder.encode(member.getPw());
        member.setPw(encodedPassword);

        repository.save(member);
    }
}
