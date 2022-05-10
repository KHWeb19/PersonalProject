package com.example.demo.repository.jpa.Local;

import com.example.demo.entity.jpa.Local.LocalBoard;
import com.example.demo.entity.jpa.Local.LocalComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LocalCommentRepository extends JpaRepository<LocalComment, Long> {
    List<LocalComment> findLocalCommentByLocalBoard(LocalBoard localBoard);
}

