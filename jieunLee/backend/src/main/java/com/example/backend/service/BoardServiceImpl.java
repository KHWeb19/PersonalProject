package com.example.backend.service;

import com.example.backend.entity.Board;
import com.example.backend.entity.Member;
import com.example.backend.repository.BoardRepository;
import com.example.backend.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardRepository repository;

    @Autowired
    MemberRepository memberRepository;

    @Override
    public void register(Board board) {
        repository.save(board);
    }

    @Override
    public List<Board> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));
    }

    @Override
    public List<Board> memberNoBoardList(Integer memberNo) {
        List<Board> myBoard = repository.selectMyBoard(Long.valueOf(memberNo));
        return myBoard;
    }


    @Override
    public List<Board> findList() {
//        List<Board> myBoard = repository.selectMyBoard(Long.valueOf(writerNo));
        List<Board> myBoard = repository.selectMyBoard(Long.valueOf(75));
        return myBoard;
    }

    @Override
    public Board read(Integer boardNo) {
        Optional<Board> maybeReadBoard = repository.findById(Long.valueOf(boardNo));

        if (maybeReadBoard.equals(Optional.empty())) {
            return null;
        }

        return maybeReadBoard.get();
    }

    @Override
    public void modify(Board board) {
        repository.save(board);
    }

    @Override
    public void remove(Integer boardNo) {
        repository.deleteById(Long.valueOf(boardNo));
    }
}
