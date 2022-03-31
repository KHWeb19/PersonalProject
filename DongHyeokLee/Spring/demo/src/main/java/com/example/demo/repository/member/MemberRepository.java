package com.example.demo.repository.member;

import com.example.demo.entitiy.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("select m from Member m where m.userId = :userId")
    Optional<Member> findByUserId(String userId);

    @Query("select m.memberNo from Member m where m.userId = :userId")
    Optional<Member> findByMemberNo(String userId);
}
