package com.example.demo.repository;

import com.example.demo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JoinMemberRepository extends JpaRepository<Member, Long> {
    Boolean existsById(String id);
}
