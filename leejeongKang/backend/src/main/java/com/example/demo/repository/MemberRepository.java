package com.example.demo.repository;

import com.example.demo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query(value = "select * from Member as m where m.id = :id", nativeQuery = true)
    Optional<Member> findById(@Param("id") String id);

    /*@Query(value = "update * from Member", nativeQuery = true)
    Optional<Member> updateInform(@Param())*/
}
