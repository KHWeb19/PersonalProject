package com.example.backend.service;

import com.example.backend.entity.Follow;
import com.example.backend.entity.Likes;

import java.util.List;

public interface FollowService {
    boolean register (Long memberNo, Long loginNo, Follow follow);
    List<Follow> followList (Long memberNo);
}
