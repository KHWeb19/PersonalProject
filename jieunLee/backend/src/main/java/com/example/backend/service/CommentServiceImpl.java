package com.example.backend.service;

import com.example.backend.entity.Board;
import com.example.backend.entity.Comment;
import com.example.backend.entity.Member;
import com.example.backend.repository.BoardRepository;
import com.example.backend.repository.CommentRepository;
import com.example.backend.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    CommentRepository repository;

    @Override
    public void register(Integer boardNo, Integer memberNo, Comment comment) {

        Optional<Board> maybeBoard = boardRepository.findById(Long.valueOf(boardNo));
        comment.setBoard(maybeBoard.get());
        Optional<Member> maybeMember = memberRepository.findById(Long.valueOf(memberNo));
        comment.setMember(maybeMember.get());

        repository.save(comment);
    }

    @Override
    public List<Comment> list(Integer boardNo) {
        return repository.findAllByBoardNo(Long.valueOf(boardNo));
    }

    @Override
    public void modify(Comment comment) {
        repository.save(comment);
    }

    @Override
    public void remove(Integer commentNo) {
        repository.deleteById(Long.valueOf(commentNo));
    }
}
