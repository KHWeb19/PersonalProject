package com.example.demo.service.jpa.Complaint;

import com.example.demo.entity.jpa.Complaint.ComplaintComment;

import java.util.List;

public interface ComplaintCommentService {
    public void register (Integer boardNo, ComplaintComment complaintComment);
    public List<ComplaintComment> list (Integer boardNo);
    public void delete (Long commentId);
}


