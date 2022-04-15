package com.example.demo.service.StoreBoard;

import com.example.demo.entity.StoreBoard;
import com.example.demo.repository.StoreBoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class StoreBoardServiceImpl implements StoreBoardService {

    @Autowired
    StoreBoardRepository repository;

    @Override
    public void register (StoreBoard board)  {
        repository.save(board);
    }

    @Override
    public List<StoreBoard> list() {
        log.info("StoreBoardServiceImpl");
        return repository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));
    }

}
