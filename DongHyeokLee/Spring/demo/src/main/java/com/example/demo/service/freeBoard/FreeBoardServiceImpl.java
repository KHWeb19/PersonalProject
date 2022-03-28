package com.example.demo.service.freeBoard;


import com.example.demo.entitiy.freeBoard.FreeBoard;
import com.example.demo.repository.freeBoard.FreeBoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
public class FreeBoardServiceImpl implements FreeBoardService {

    @Autowired
    FreeBoardRepository repository;

    @Override
    public void register(FreeBoard freeBoard) {
        repository.save(freeBoard);
    }

    @Override
    public List<FreeBoard> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));
    }
}
