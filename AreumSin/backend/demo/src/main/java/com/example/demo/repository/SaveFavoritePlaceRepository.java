package com.example.demo.repository;

import com.example.demo.entity.SaveFavoritePlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SaveFavoritePlaceRepository extends JpaRepository<SaveFavoritePlace, Integer> {

    @Transactional
    @Query("select fp from SaveFavoritePlace fp where fp.member.id = :id")
    List<SaveFavoritePlace> findAllByMemberId(String id);
}
