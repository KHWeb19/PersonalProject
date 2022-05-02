package com.example.demo.repository;

import com.example.demo.entity.DiaryImg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface DiaryImgRepository extends JpaRepository<DiaryImg, Integer> {

    @Transactional
    @Query("select di from DiaryImg di where di.diary.DiaryNo = :diaryNo")
    List<DiaryImg> getByDiaryNo(Integer diaryNo);

    @Transactional
    @Query("select di from DiaryImg di where di.diaryImgNo =: diaryImgNo")
    List<DiaryImg> findByDiaryImgNo(List<Integer> diaryImgNo);
}
