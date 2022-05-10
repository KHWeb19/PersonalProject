package com.example.demo.service.jpa.Complaint;

import com.example.demo.entity.jpa.Complaint.ComplaintBoard;
import com.example.demo.entity.jpa.Complaint.ComplaintComment;
import com.example.demo.repository.jpa.Complaint.ComplaintBoardRepository;
import com.example.demo.repository.jpa.Complaint.ComplaintCommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ComplaintCommentServiceImpl implements ComplaintCommentService {

    @Autowired
    ComplaintBoardRepository boardRepository;

    @Autowired
    ComplaintCommentRepository repository;

    @Override
    public void register (Integer boardNo, ComplaintComment complaintComment){
        Optional<ComplaintBoard> boardItem = boardRepository.findById(Long.valueOf(boardNo));
        complaintComment.setComplaintBoard(boardItem.get());
        repository.save(complaintComment);
    }

    @Override
    public List<ComplaintComment> list (Integer boardNo) {
        ComplaintBoard complaintBoard = boardRepository.findById(Long.valueOf(boardNo)).get();
        return repository.findComplaintCommentByComplaintBoard(complaintBoard);
    }

    @Override
    public void delete (Long commentId) {
        repository.deleteById(Long.valueOf(commentId));
    }
}