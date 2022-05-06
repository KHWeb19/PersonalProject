package com.example.backend.repository.centerBoard;

import com.example.backend.entity.Board;
import com.example.backend.entity.Center;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CenterRepository extends JpaRepository<Center, Long> {
    List<Center> findByTitleContaining(String keyWord);
}
