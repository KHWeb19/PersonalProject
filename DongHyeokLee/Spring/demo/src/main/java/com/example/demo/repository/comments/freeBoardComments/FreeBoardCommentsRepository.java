package com.example.demo.repository.comments.freeBoardComments;

import com.example.demo.entitiy.board.freeBoard.comments.FreeBoardComments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreeBoardCommentsRepository extends JpaRepository<FreeBoardComments, Long> {
}
