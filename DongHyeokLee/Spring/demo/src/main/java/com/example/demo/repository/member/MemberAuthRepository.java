package com.example.demo.repository.member;

import com.example.demo.entitiy.member.MemberAuth;
import org.springframework.data.jpa.repository.JpaRepository;





public interface MemberAuthRepository extends JpaRepository<MemberAuth, Long> {
}
