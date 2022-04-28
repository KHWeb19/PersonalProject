package com.example.demo.service;


import com.example.demo.entity.ProductBoardS;
import com.example.demo.repository.ProductBoardSRepository;
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

public class ProductBoardSServiceImpl implements ProductBoardSService {

    @Autowired
    private ProductBoardSRepository repository;

    @Override
    public void register(ProductBoardS board) {
        repository.save(board);
    }

    @Override
    public List<ProductBoardS> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));
    }

    @Override
    public ProductBoardS read(Integer boardNo) {
        Optional<ProductBoardS> maybeReadBoard = repository.findById(Long.valueOf(boardNo));

        if (maybeReadBoard.equals(Optional.empty())) {
            log.info("Can't read board!");
            return null;
        }

        return maybeReadBoard.get();
    }

    @Override
    public void modify(ProductBoardS board) {
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
    public List<ProductBoardS> userRead(String id) throws Exception {
        List<ProductBoardS> productBoardSList = repository.userRead(id);

        return productBoardSList;
    }

}