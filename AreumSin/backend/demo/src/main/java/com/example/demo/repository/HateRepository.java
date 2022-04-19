package com.example.demo.repository;

import com.example.demo.entity.Hate;
import com.example.demo.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface HateRepository extends JpaRepository<Hate, Integer> {

    @Transactional
    @Query("select h from Hate h where h.planDay.planDayNo = :planDayNo")
    Optional<Hate> findByDayHate(Integer planDayNo);

    @Transactional
    @Query("select h from Hate h where h.planDay.planDayNo = :planDayNo")
    List<Hate> findByMembers(Integer planDayNo);

    @Transactional
    @Query("select h from Hate h where h.planDay.planDayNo = :planDayNo")
    List<Hate> findByLike(Integer planDayNo);
}
