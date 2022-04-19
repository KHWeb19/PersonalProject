package com.example.backend.repository.jpa;

import com.example.backend.entity.jpa.MemberAuth;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaMemberAuthRepository extends JpaRepository<MemberAuth, Long> {
}
