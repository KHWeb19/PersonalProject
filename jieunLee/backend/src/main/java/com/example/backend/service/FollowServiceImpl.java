package com.example.backend.service;

import com.example.backend.entity.Follow;
import com.example.backend.entity.Member;
import com.example.backend.repository.FollowRepository;
import com.example.backend.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FollowServiceImpl implements FollowService{
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    FollowRepository followRepository;

    @Override
    public boolean register(Long loginNo, Long memberNo, Follow follow) {
        Member my = memberRepository.findById(loginNo).orElseThrow();
        Member your = memberRepository.findById(memberNo).orElseThrow();

        if(followRepository.findByMyAndYour(my, your).isEmpty()) {
            follow.setMy(my);
            follow.setYour(your);
            followRepository.save(follow);
            return true;
        } else {
            Optional<Follow> maybeFollow = followRepository.findByMyAndYour(my, your);
            followRepository.deleteById(maybeFollow.get().getNo());
            return false;
        }
    }

    @Override
    public List<Follow> followList(Long memberNo) {
        return followRepository.findByMy(Long.valueOf(memberNo));
    }
}
