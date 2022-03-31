package com.example.demo.service.presonalProject;

import com.example.demo.entity.personalProject.Member;
import com.example.demo.repository.personalProject.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository repository;

    @Override
    public void register(Member member) {
        repository.save(member);
    }
}
