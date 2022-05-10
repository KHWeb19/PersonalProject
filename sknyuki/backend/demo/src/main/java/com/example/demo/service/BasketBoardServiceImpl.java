package com.example.demo.service;


import com.example.demo.entity.BasketBoard;
import com.example.demo.repository.BasketBoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Lazy
@Slf4j
@Service

public class BasketBoardServiceImpl implements BasketBoardService {

    @Autowired
    private BasketBoardRepository repository;

    @Override
    public void register(BasketBoard board) {
        repository.save(board);
    }


    @Override
    public BasketBoard read(Integer basketNo) {
        Optional<BasketBoard> maybeReadBoard = repository.findById(Long.valueOf(basketNo));

        if (maybeReadBoard.equals(Optional.empty())) {
            log.info("Can't read board!");
            return null;
        }

        return maybeReadBoard.get();
    }

    @Override
    public void modify(BasketBoard board) {
        repository.save(board);
    }

    @Override
    public void remove(Integer basketNo) {
        repository.deleteById(Long.valueOf(basketNo));
    }

    /*@Override
    public List<BrandCheckBoard> userRead(String id) {
        Optional<BrandCheckBoard> maybeReadId = repository.findById(Long.valueOf(id));

        if (maybeReadId.equals(Optional.empty())) {
            log.info("Can't read Id!");
            return null;
        }

        return (List<BrandCheckBoard>) maybeReadId.get();
    }*/
    @Override
    public List<BasketBoard> userRead(String id) throws Exception {
        List<BasketBoard> BasketBoardList = repository.userRead(id);

        return BasketBoardList;
    }

}