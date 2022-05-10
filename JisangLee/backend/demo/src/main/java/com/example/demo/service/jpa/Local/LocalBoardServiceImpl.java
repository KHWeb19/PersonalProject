package com.example.demo.service.jpa.Local;

import com.example.demo.entity.jpa.Local.LocalBoard;
import com.example.demo.repository.jpa.Local.LocalBoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class LocalBoardServiceImpl implements LocalBoardService {

    @Autowired
    LocalBoardRepository repository;

    @Override
    public void register(LocalBoard board) {
        repository.save(board);
    }

    @Override
    public List<LocalBoard> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));
    }

    @Override
    public LocalBoard read(Integer boardNo) {
        Optional<LocalBoard> maybeReadBoard = repository.findById(Long.valueOf(boardNo));

        if (maybeReadBoard.equals(Optional.empty())) {
            log.info("Can't read board!");
            return null;
        } else {
            LocalBoard localBoard = maybeReadBoard.get();
            localBoard.increaseViewCnt();
            repository.save(localBoard);
            return maybeReadBoard.get();
        }
    }

    @Override
    public void modify(LocalBoard board) {
        repository.save(board);
    }

    @Override
    public void remove(Integer boardNo) {
        repository.deleteById(Long.valueOf(boardNo));
    }
}