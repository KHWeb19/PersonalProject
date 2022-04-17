package com.example.demo.repository;

import com.example.demo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("select m from Member m where m.userId = :userId")
    Optional<Member> findByUserId(String userId);

    @Transactional
    @Query(value = "select * from member where member_no in" +
            "(select member from where auth = :auth)", nativeQuery = true)
    public List<Member> selectMemberWithRole(String auth);

}


