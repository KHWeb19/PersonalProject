package com.example.demo.repository.jpa.Complaint;

import com.example.demo.entity.jpa.Complaint.ComplaintBoard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintBoardRepository extends JpaRepository<ComplaintBoard, Long> {
}
