package com.example.demo.repository;

import com.example.demo.controller.memberController.request.MemberRequest;
import com.example.demo.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import javax.transaction.Transactional;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {

    @Transactional
    @Query("select m from Member m where m.userId = :userId")
    Optional<Member> findByUserId(String userId);

}
