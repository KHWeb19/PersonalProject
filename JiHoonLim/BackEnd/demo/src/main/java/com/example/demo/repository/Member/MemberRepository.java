package com.example.demo.repository.Member;

import com.example.demo.entity.Member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("select m from Member m where m.id = :id")
    Optional<Member> findByUserId(String id);

    @Query("select m from Member m where m.nickName = :nickName")
    Optional<Member> findByUserNickName(String nickName);

    @Query("select m from Member m where m.email = :email")
    Optional<Member> findByUserEmail(String email);

    @Query("select m.id from Member m where m.email = :email")
    List searchUserId(@Param("email") String email);



}
