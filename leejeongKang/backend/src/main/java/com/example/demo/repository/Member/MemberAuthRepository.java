package com.example.demo.repository.Member;

import com.example.demo.entity.Member.MemberAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberAuthRepository extends JpaRepository<MemberAuth, Long> {

    @Query(value = "select ma.auth from member_auth as ma where ma.member_no = :member_no", nativeQuery = true)
    Optional<MemberAuth> findByMemberNo(@Param("member_no") Long member_no);

}
