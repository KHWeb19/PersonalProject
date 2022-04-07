package com.example.demo.service.order62;

import com.example.demo.entity.jpa.JpaBoards2;

import com.example.demo.repository.jpa.order63.JpaBoardRepositorys2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class JpaBoardServicesImpls2 implements JpaBoardServices2 {

    @Autowired
    JpaBoardRepositorys2 repository;

    @Override
    public void register(JpaBoards2 board) {
        repository.save(board);
    }

    @Override
    public List<JpaBoards2> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));
    }

    @Override
    public JpaBoards2 read(Integer boardNo) {
        Optional<JpaBoards2> maybeReadBoard = repository.findById(Long.valueOf(boardNo));

        if (maybeReadBoard.equals(Optional.empty())) {
            log.info("Can't read board!");
            return null;
        }

        return maybeReadBoard.get();
    }

    @Override
    public void modify(JpaBoards2 board) {
        repository.save(board);
    }

    @Override
    public void remove(Integer boardNo) {
        repository.deleteById(Long.valueOf(boardNo));
    }
}
