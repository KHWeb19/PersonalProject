package com.example.demo.repository;

import com.example.demo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Optional;

public interface JoinMemberRepository extends JpaRepository<Member, Long> {
    Boolean existsById(String id);

    @Transactional
    @Query("select m from Member m where m.id = :id")
    Optional<Member> findById(String id);

    @Transactional
    @Query("select m from Member m where m.id = :id")
    Member findByMemberNo(String id);

    @Transactional
    @Query("select m.memberNo from Member m where m.id = :id")
    Integer findByIntMemberNo(String id);

    @Transactional
    @Query("select m from Member m where m.name = :name and m.birth = :birth")
    Optional<Member> findIdByNameBirth(String name, Integer birth);

    @Transactional
    @Query("select m from Member m where m.name = :name and m.id = :id")
    Optional<Member> findPwByNameId(String name, String id);

}
