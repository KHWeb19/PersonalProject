package com.example.backend.repository.jpa;


import com.example.backend.entity.jpa.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface JpaMemberRepository extends JpaRepository<Member, Long> {

    // 아이디 중복 검사
    @Query("select m from Member m where m.userId = :userId")
    Optional<Member> findByDuplicateCheck(@Param("userId") String userId);


//    List<Member> findByUserId(String userId);

    @Query("select m from Member m where m.userId = :userId")
    Optional<Member> findByUserInfo(@Param("userId") String userId);


    @Query("select m from Member m join fetch m.authList where m.memberNo = :memberNo")
    Optional<Member> findByAuth(@Param("memberNo") Long memberNo);


}
