package com.example.backend.repository;

import com.example.backend.entity.Board;
import com.example.backend.entity.Comment;
import com.example.backend.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByMemberIdContainingOrMemberNameContaining(String id, String name);


    @Query("select m from Member m where m.memberId = :memberId")
    Optional<Member> findByUserId(String memberId);

}
