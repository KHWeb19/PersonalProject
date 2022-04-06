package com.example.backend.repository;

import com.example.backend.entity.MemberAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberAuthRepository extends JpaRepository<MemberAuth, Long> {
    @Query("select ma.auth from MemberAuth ma where ma.member = :member")
    Optional<MemberAuth> findByMemberNo(Long member);
}

