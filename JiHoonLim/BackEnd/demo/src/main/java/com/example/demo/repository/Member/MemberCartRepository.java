package com.example.demo.repository.Member;

import com.example.demo.entity.Member.MemberCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface MemberCartRepository extends JpaRepository<MemberCart, Long> {
    Optional<MemberCart> findBoardNoByMemberNoAndBoardNo(Long memberNo,Long boardNo);

    @Transactional
    @Query("select cl from MemberCart cl where cl.memberNo = :memberNo")
    List<MemberCart> findCartList(@Param("memberNo")Long memberNo);
}
