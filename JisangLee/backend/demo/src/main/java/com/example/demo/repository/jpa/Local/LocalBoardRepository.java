package com.example.demo.repository.jpa.Local;

import com.example.demo.entity.jpa.Local.LocalBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalBoardRepository extends JpaRepository<LocalBoard, Long> {
}
