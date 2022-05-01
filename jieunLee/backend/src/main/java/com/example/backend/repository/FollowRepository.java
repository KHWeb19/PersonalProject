package com.example.backend.repository;

import com.example.backend.entity.Board;
import com.example.backend.entity.Follow;
import com.example.backend.entity.Likes;
import com.example.backend.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    Optional<Follow> findByMyAndYour (Member my, Member your);
}
