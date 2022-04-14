package com.example.demo.service.order62;

import com.example.demo.entity.jpa.JpaBoards1;



import com.example.demo.repository.jpa.order63.JpaBoardRepositorys1;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class JpaBoardServicesImpls1 implements JpaBoardServices1 {

    @Autowired
    JpaBoardRepositorys1 repository;

    @Override
    public void register(JpaBoards1 board) {
        repository.save(board);
    }

    @Override
    public List<JpaBoards1> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));
    }


    @Override
    public List<JpaBoards1> search(String keyword) {
        return repository.findAllByTitleContainingOrWriterContainingOrWriter1Containing(keyword, keyword, keyword);
    }

    @Override
    public JpaBoards1 read(Integer boardNo) {
        Optional<JpaBoards1> maybeReadBoard = repository.findById(Long.valueOf(boardNo));

        if (maybeReadBoard.equals(Optional.empty())) {
            log.info("Can't read board!");
            return null;
        }

        return maybeReadBoard.get();
    }

    @Override
    public void modify(JpaBoards1 board) {
        repository.save(board);
    }

    @Override
    public void remove(Integer boardNo) {
        repository.deleteById(Long.valueOf(boardNo));
    }
}
