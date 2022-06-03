package com.example.demo.repository.jpa.Foreign;

import com.example.demo.entity.jpa.Foreign.ForeignBoard;
import com.example.demo.entity.jpa.Foreign.ForeignComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ForeignCommentRepository extends JpaRepository<ForeignComment, Long> {
    List<ForeignComment> findForeignCommentByForeignBoard(ForeignBoard foreignBoard);
}



