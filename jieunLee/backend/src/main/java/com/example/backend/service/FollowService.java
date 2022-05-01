package com.example.backend.service;

import com.example.backend.entity.Follow;

public interface FollowService {
    boolean register (Long memberNo, Long loginNo, Follow follow);
}
