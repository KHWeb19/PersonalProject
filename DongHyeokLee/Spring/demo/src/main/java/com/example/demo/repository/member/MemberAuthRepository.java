package com.example.demo.repository.member;

import com.example.demo.entity.member.MemberAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.Optional;


public interface MemberAuthRepository extends JpaRepository<MemberAuth, Long> {


    @Query("select ma.auth from MemberAuth ma where ma.memberNo = :memberNo")
    Optional<MemberAuth> findByMemberNo(@Param("memberNo") Long memberNo);
}
