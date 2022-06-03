package com.example.demo.service.jpa.Foreign;

import com.example.demo.entity.jpa.Foreign.ForeignBoard;
import com.example.demo.repository.jpa.Foreign.ForeignBoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ForeignBoardServiceImpl implements ForeignBoardService {

    @Autowired
    ForeignBoardRepository repository;

    @Override
    public void register(ForeignBoard board) {
        repository.save(board);
    }

    @Override
    public List<ForeignBoard> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));
    }

    @Override
    public ForeignBoard read(Integer boardNo) {
        Optional<ForeignBoard> maybeReadBoard = repository.findById(Long.valueOf(boardNo));

        if (maybeReadBoard.equals(Optional.empty())) {
            log.info("Can't read board!");
            return null;
        } else {
            ForeignBoard foreignBoard = maybeReadBoard.get();
            foreignBoard.increaseViewCnt();
            repository.save(foreignBoard);
            return maybeReadBoard.get();
        }
    }

    @Override
    public void modify(ForeignBoard board) {
        repository.save(board);
    }

    @Override
    public void remove(Integer boardNo) {
        repository.deleteById(Long.valueOf(boardNo));
    }
}