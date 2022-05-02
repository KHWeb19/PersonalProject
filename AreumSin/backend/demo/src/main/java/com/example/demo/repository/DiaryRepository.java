package com.example.demo.repository;

import com.example.demo.entity.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DiaryRepository extends JpaRepository<Diary, Integer> {

    @Transactional
    @Query("select d from Diary d where d.member.id = :id ")
    List<Diary> findDiaryByMemberId(String id);

    @Transactional
    @Query("select d from Diary d where d.DiaryNo = :diaryNo")
    Diary findByDiaryNo(Integer diaryNo);
}
