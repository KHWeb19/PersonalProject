package com.example.demo.repository;

import com.example.demo.entity.member.MemberAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberAuthRepository extends JpaRepository<MemberAuth, Long> {
}
