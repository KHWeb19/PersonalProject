package com.example.demo.repository.personalProject;

import com.example.demo.entity.personalProject.MemberAuthCheckId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberAuthCheckIdRepository extends JpaRepository<MemberAuthCheckId, Long> {
    @Query("select m from MemberAuthCheckId m where m.userId = :userId")
    Optional<MemberAuthCheckId> findByUserId(String userId);
}
