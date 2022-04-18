package com.example.demo.repository.Member;

import com.example.demo.entity.Member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Transactional
    @Query(value = "select * from Member as m where m.id = :id", nativeQuery = true)
    Optional<Member> findById(@Param("id") String id);

    @Transactional
    @Query(value = "select * from Member as m where m.memberNo = :memberNo", nativeQuery = true)
    Optional<Member> readById(@Param("memberNo") Long memberNo);

}
