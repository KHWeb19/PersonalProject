package com.example.demo.repository.personalProject;

import com.example.demo.entity.personalProject.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
