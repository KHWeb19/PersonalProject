package com.example.demo.repository;

import com.example.demo.entity.StoreBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreBoardRepository  extends JpaRepository<StoreBoard, Long> {
}
