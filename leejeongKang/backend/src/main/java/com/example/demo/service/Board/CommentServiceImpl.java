package com.example.demo.service.Board;

import com.example.demo.entity.Board.Board;
import com.example.demo.entity.Board.Comment;
import com.example.demo.repository.Board.BoardRepository;
import com.example.demo.repository.Board.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    BoardRepository boardRepository;

    @Override
    public void register(Comment comment, Long boardNo){
        Optional<Board> findBoard = boardRepository.findById(Long.valueOf(boardNo));

        comment.setBoard(findBoard.get());
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> list (Long boardNo){
        Board board = boardRepository.findById(Long.valueOf(boardNo)).get();

        return commentRepository.findCommentByBoard(board);
    }

    @Override
    public void delete (Long commentNo) {
        commentRepository.deleteById(Long.valueOf(commentNo));
    }
}
