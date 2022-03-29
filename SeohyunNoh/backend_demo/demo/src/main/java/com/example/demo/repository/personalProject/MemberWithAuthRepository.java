package com.example.demo.repository.personalProject;

import com.example.demo.entity.personalProject.MemberWithAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberWithAuthRepository extends JpaRepository<MemberWithAuth, Long> {
    @Query("select m from MemberWithAuth m where m.userId = :userId")
    Optional<MemberWithAuth> findByUserId(String userId);
}
