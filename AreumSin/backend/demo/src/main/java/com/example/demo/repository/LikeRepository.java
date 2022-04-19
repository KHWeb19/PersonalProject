package com.example.demo.repository;

import com.example.demo.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface LikeRepository extends JpaRepository<Like, Integer> {

    @Transactional
    @Query("select l from Like l where l.planDay.planDayNo = :planDayNo")
    Optional<Like> findByDayLike(Integer planDayNo);

    @Transactional
    @Query("select l from Like l where l.planDay.planDayNo = :planDayNo")
    List<Like> findByMembers(Integer planDayNo);

    @Transactional
    @Query("select l from Like l where l.planDay.planDayNo = :planDayNo")
    List<Like> findByLike(Integer planDayNo);

}
