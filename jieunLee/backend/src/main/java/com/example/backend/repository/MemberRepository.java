package com.example.backend.repository;

import com.example.backend.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Transactional
    @Query(value = "select * from member where member_no in(select member_member_no from member_auth where auth = :auth)", nativeQuery = true)
    public List<Member> selectMemberWithRole(String auth);

    @Query("select m from Member m where m.memberId = :memberId")
    Optional<Member> findByUserId(String memberId);
}
