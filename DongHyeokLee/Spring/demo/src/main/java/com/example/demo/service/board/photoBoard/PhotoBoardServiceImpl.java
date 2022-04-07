package com.example.demo.service.board.photoBoard;

import com.example.demo.entitiy.board.freeBoard.FreeBoard;
import com.example.demo.entitiy.board.photoBoard.PhotoBoard;
import com.example.demo.repository.board.photoBoard.PhotoBoardRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class PhotoBoardServiceImpl implements PhotoBoardService{

    @Autowired
    private PhotoBoardRepository repository;

    @Override
    public void register(PhotoBoard photoBoard) {
            repository.save(photoBoard);

    }

    @Override
    public List<PhotoBoard> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));
    }

    @Override
    public PhotoBoard read(Integer boardNo) {
        Optional<PhotoBoard> maybeReadBoard = repository.findById(Long.valueOf(boardNo));

        if (maybeReadBoard.equals(Optional.empty())){
            log.info("Can't read board!!");
            return null;
        }
        return maybeReadBoard.get();
    }
}
