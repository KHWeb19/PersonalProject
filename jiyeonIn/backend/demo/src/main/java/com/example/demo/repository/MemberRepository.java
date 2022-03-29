package com.example.demo.repository;

import com.example.demo.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface MemberRepository extends JpaRepository<Member,Long> {

    @Transactional
    @Query(value = "select * from cake_member where member_no in (select for_member_no from cake_member_auth where auth = :auth)",nativeQuery = true )
    public List<Member> selectMemberwithRole(String auth);

}
