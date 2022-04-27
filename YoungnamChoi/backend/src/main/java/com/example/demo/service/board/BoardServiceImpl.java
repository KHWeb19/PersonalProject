package com.example.demo.service.board;

import com.example.demo.entity.board.Board;

import com.example.demo.repository.BoardRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardRepository repository;

    @Override
    public void register(Board board) {
        repository.save(board);
    }

    @Override
    public List<Board> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));
    }

    @Override
    public Board read(Integer boardNo) {
        Optional<Board> maybeReadBoard = repository.findById(Long.valueOf(boardNo));

        if (maybeReadBoard.equals(Optional.empty())) {
            log.info("Can't read board!");
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
