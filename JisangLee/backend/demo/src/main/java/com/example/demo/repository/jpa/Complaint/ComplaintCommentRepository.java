package com.example.demo.repository.jpa.Complaint;

import com.example.demo.entity.jpa.Complaint.ComplaintBoard;
import com.example.demo.entity.jpa.Complaint.ComplaintComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplaintCommentRepository extends JpaRepository<ComplaintComment, Long> {
    List<ComplaintComment> findComplaintCommentByComplaintBoard(ComplaintBoard complaintBoard);
}

