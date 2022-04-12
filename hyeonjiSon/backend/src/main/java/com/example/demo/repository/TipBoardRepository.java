package com.example.demo.repository;

import com.example.demo.entity.TipBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipBoardRepository extends JpaRepository<TipBoard, Long> {
}
