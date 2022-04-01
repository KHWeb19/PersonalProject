package com.example.demo.service.order62;

import com.example.demo.entity.jpa.JpaBoards;

import com.example.demo.repository.jpa.order63.JpaBoardRepositorys;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class JpaBoardServicesImpls implements JpaBoardServices {

    @Autowired
    JpaBoardRepositorys repository;

    @Override
    public void register(JpaBoards board) {
        repository.save(board);
    }

    @Override
    public List<JpaBoards> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));
    }

    @Override
    public JpaBoards read(Integer boardNo) {
        Optional<JpaBoards> maybeReadBoard = repository.findById(Long.valueOf(boardNo));

        if (maybeReadBoard.equals(Optional.empty())) {
            log.info("Can't read board!");
            return null;
        }

        return maybeReadBoard.get();
    }

    @Override
    public void modify(JpaBoards board) {
        repository.save(board);
    }

    @Override
    public void remove(Integer boardNo) {
        repository.deleteById(Long.valueOf(boardNo));
    }
}
