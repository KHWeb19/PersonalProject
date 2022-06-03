package com.example.demo.repository.jpa;

import com.example.demo.entity.jpa.VueJpaMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface VueJpaMemberRepository extends JpaRepository<VueJpaMember, Long> {

    @Query(value = "select * from Vue_Jpa_Member where id = :userId", nativeQuery = true)
    Optional<VueJpaMember> findByUserId(String userId);

    @Query(value = "select * from Vue_Jpa_Member where nickname = :userNickname", nativeQuery = true)
    Optional<VueJpaMember> findByUserNickname(String userNickname);

}
