package com.example.demo.repository.personalProject;

import com.example.demo.controller.request.MemberRequest;
import com.example.demo.entity.personalProject.Member;
import com.example.demo.entity.personalProject.MemberAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("select m from Member m where m.id = :id")
    Optional<Member> findByUserId(String id);

}
