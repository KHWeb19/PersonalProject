package com.example.backend.repository;

import com.example.backend.entity.Board;
import com.example.backend.entity.Follow;
import com.example.backend.entity.Likes;
import com.example.backend.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    Optional<Follow> findByMyAndYour (Member my, Member your);

    @Query(value = "select * from follow where my_no in(select member_no from member where member_no = :memberNo)", nativeQuery = true)
    List<Follow> findByMy(@Param("memberNo") Long memberNo);
}
