package com.example.demo.repository.personalProject;

import com.example.demo.entity.personalProject.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("select m from Member m where m.auth=:auth and m.id=:id and m.pw=:pw")
    Member selectUserInfo(@Param("auth")String auth, @Param("id")String id, @Param("pw")String pw);

}
