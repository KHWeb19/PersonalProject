package com.example.demo.repository;

import com.example.demo.entity.SaveFavoritePlace;
import com.example.demo.request.SaveFavoritePlaceDay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SaveFavoritePlaceRepository extends JpaRepository<SaveFavoritePlace, Integer> {

    @Transactional
    @Query("select fp from SaveFavoritePlace fp where fp.member.id = :id")
    List<SaveFavoritePlace> findAllByMemberId(String id);

    @Transactional
    @Query("select fp from SaveFavoritePlace fp where fp.plan.planNo = :planNo")
    List<SaveFavoritePlace> findMemberPlaceByPlanNo(Integer planNo);

    @Transactional
    @Query("select fp from SaveFavoritePlace fp where fp.favoritePlace = :favoritePlaceNo")
    SaveFavoritePlace findPlaceByNo(Integer favoritePlaceNo);

    @Transactional
    @Query("select fp from SaveFavoritePlace fp where fp.plan.planNo = :planNo and fp.day = :day")
    List<SaveFavoritePlace> findPlaceByDay(Integer day, Integer planNo);

    @Transactional
    @Query("select fp from SaveFavoritePlace fp where fp.member.memberNo = :memberNo")
    List<SaveFavoritePlace> findPlaceByUserNo(Integer memberNo);
}
