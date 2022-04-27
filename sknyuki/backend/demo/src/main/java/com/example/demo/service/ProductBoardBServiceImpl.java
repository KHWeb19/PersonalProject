package com.example.demo.service;


import com.example.demo.entity.ProductBoardB;
import com.example.demo.repository.ProductBoardBRepository;
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

public class ProductBoardBServiceImpl implements ProductBoardBService {

    @Autowired
    private ProductBoardBRepository repository;

    @Override
    public void register(ProductBoardB board) {
        repository.save(board);
    }

    @Override
    public List<ProductBoardB> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));
    }

    @Override
    public ProductBoardB read(Integer boardNo) {
        Optional<ProductBoardB> maybeReadBoard = repository.findById(Long.valueOf(boardNo));

        if (maybeReadBoard.equals(Optional.empty())) {
            log.info("Can't read board!");
            return null;
        }

        return maybeReadBoard.get();
    }

    @Override
    public void modify(ProductBoardB board) {
        repository.save(board);
    }

    @Override
    public void remove(Integer boardNo) {
        repository.deleteById(Long.valueOf(boardNo));
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
    public List<ProductBoardB> userRead(String id) throws Exception {
        List<ProductBoardB> productBoardBList = repository.userRead(id);

        return productBoardBList;
    }

}