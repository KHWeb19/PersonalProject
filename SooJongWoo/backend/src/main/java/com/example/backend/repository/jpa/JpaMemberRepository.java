package com.example.backend.repository.jpa;

import com.example.backend.entity.jpa.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;


public interface JpaMemberRepository extends JpaRepository<Member, Long> {

    @Query("select m from Member m where m.userId = :userId")
    Optional<Member> findByDuplicateCheck(@Param("userId") String userId);
}
