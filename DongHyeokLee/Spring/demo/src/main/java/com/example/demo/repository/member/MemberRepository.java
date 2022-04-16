package com.example.demo.repository.member;

import com.example.demo.entitiy.member.MemberInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.Optional;

public interface MemberRepository extends JpaRepository<MemberInfo, Long> {

    @Query("select m from MemberInfo m where m.userId = :userId")
    Optional<MemberInfo> findByUserId(@Param("userId") String userId);

    @Query("select m.userId from MemberInfo m where m.userId = :userId")
    Optional<MemberInfo> checkUserId(@Param("userId") String userId);

    @Query("select m.nickname from MemberInfo m where m.nickname = :nickname")
    Optional<MemberInfo> checkNickname(@Param("nickname") String nickname);

    @Query("select m.email from MemberInfo m where m.email = :email")
    Optional<MemberInfo> checkEmail(@Param("email") String email);

}
