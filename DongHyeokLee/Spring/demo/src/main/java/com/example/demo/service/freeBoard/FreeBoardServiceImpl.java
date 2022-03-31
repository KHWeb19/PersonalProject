package com.example.demo.service.freeBoard;


import com.example.demo.entitiy.freeBoard.FreeBoard;
import com.example.demo.repository.freeBoard.FreeBoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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

    @Override
    public FreeBoard read(Integer boardNo) {
        Optional<FreeBoard> maybeReadBoard = repository.findById(Long.valueOf(boardNo));

        if (maybeReadBoard.equals(Optional.empty())){
            log.info("Can't read board!!");
            return null;
        }
        return maybeReadBoard.get();
    }

    @Override
    public void modify(FreeBoard board) {
        repository.save(board);

    }

    @Override
    public void remove(Integer boardNo) {
        repository.deleteById(Long.valueOf(boardNo));
    }
}
