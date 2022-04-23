package com.example.demo.repository;

import com.example.demo.entity.member.MemberAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Optional;

public interface MemberAuthRepository extends JpaRepository<MemberAuth, Long> {

    @Transactional
    @Query(value = "select * from cake_member_auth where for_member_no = :memberNo",nativeQuery = true)
    Optional<MemberAuth> findByMemberNo(Long memberNo);

}
