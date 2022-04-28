package com.example.demo.repository;

import com.example.demo.entity.SaveFavoritePlace;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaveFavoritePlaceRepository extends JpaRepository<SaveFavoritePlace, Integer> {
}
