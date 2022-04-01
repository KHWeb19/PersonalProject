package com.example.demo.repository;

import com.example.demo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface JoinMemberRepository extends JpaRepository<Member, Long> {
    Boolean existsById(String id);

    @Query("select m from Member m where m.id = :id")
    Optional<Member> findById(String id);

    @Query("select m from Member m where m.memberNo = :memberNo")
    Optional<Member> findByMemberNo(Integer memberNo);
}
