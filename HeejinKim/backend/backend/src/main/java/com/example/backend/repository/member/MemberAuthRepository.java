package com.example.backend.repository.member;

import com.example.backend.entity.MemberAuth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Optional;


public interface MemberAuthRepository extends JpaRepository<MemberAuth,Long> {

    @Transactional
    @Query(value = "select * from member_auth where member_no = :memberNo" , nativeQuery = true)
    Optional<MemberAuth> findByMemberNo(Long memberNo);
}
