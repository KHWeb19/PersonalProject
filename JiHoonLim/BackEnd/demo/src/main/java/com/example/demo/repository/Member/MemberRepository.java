package com.example.demo.repository.Member;

import com.example.demo.entity.Member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Transactional
    @Query("select m from Member m where m.id = :id")
    Optional<Member> findByUserId(String id);

    @Transactional
    @Query("select m from Member m where m.nickName = :nickName")
    Optional<Member> findByUserNickName(String nickName);

    @Transactional
    @Query("select m from Member m where m.email = :email")
    Optional<Member> findByUserEmail(String email);

    @Transactional
    @Query("select m.id from Member m where m.email = :email")
    List searchUserId(@Param("email") String email);

    @Transactional
    @Modifying
    @Query("update Member p set p.pw = :pw where p.id = :id ")
    void modifyPw(@Param("id")String id, @Param("pw")String pw);

    @Transactional
    @Modifying
    @Query("update Member n set n.nickName = :nickName where n.memberNo = :memberNo ")
    void modifyNickName(@Param("memberNo")Long memberNo, @Param("nickName")String nickName);

    @Transactional
    @Modifying
    @Query("update Member e set e.email = :email where e.memberNo = :memberNo ")
    void modifyEmail(@Param("memberNo")Long memberNo, @Param("email")String email);
}
