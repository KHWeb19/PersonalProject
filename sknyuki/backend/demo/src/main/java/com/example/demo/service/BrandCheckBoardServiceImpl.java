package com.example.demo.service;
import com.example.demo.entity.BrandCheckBoard;
import com.example.demo.repository.BrandCheckBoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BrandCheckBoardServiceImpl implements BrandCheckBoardService {

    @Autowired
    BrandCheckBoardRepository repository;

    @Override
    public void register(BrandCheckBoard board) {
        repository.save(board);
    }

    @Override
    public List<BrandCheckBoard> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));
    }

    @Override
    public BrandCheckBoard read(Integer boardNo) {
        Optional<BrandCheckBoard> maybeReadBoard = repository.findById(Long.valueOf(boardNo));

        if (maybeReadBoard.equals(Optional.empty())) {
            log.info("Can't read board!");
            return null;
        }

        return maybeReadBoard.get();
    }

    @Override
    public void modify(BrandCheckBoard board) {
        repository.save(board);
    }

    @Override
    public void remove(Integer boardNo) {
        repository.deleteById(Long.valueOf(boardNo));
    }
}
