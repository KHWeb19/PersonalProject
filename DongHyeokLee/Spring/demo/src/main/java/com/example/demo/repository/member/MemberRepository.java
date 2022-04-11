package com.example.demo.repository.member;

import com.example.demo.entitiy.member.MemberInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberInfo, Long> {

    @Query("select m from MemberInfo m where m.userId = :userId")
    Optional<MemberInfo> findByUserId(String userId);

    @Query("select m.userId from MemberInfo m where m.userId = :userId")
    Optional<MemberInfo> checkUserId(String userId);

    @Query("select m.nickname from MemberInfo m where m.nickname = :nickname")
    Optional<MemberInfo> checkNickname(String nickname);

    @Query("select m.email from MemberInfo m where m.email = :email")
    Optional<MemberInfo> checkEmail(String email);


    @Query("select m from MemberInfo m where m.userId = :userId")
    Optional<MemberInfo> findMemberNo(String userId);

}
