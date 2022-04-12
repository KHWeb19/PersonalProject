package com.example.demo.service.TipBoard;

import com.example.demo.entity.TipBoard;
import com.example.demo.repository.TipBoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TipBoardServiceImpl implements TipBoardService {

    @Autowired
    TipBoardRepository repository;

    @Override
    public void register(TipBoard board) {
        repository.save(board);
    }

    @Override
    public List<TipBoard> list() {
        log.info("TipBoardServiceIMPL");
        return repository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));
    }

}
