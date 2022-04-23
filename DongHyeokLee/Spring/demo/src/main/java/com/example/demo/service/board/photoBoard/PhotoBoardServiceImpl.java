package com.example.demo.service.board.photoBoard;

import com.example.demo.entitiy.board.freeBoard.FreeBoard;
import com.example.demo.entitiy.board.photoBoard.PhotoBoard;
import com.example.demo.repository.board.photoBoard.PhotoBoardRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
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

        PhotoBoard readBoard = maybeReadBoard.get();
        readBoard.setCount(readBoard.getCount()+1);
        repository.save(readBoard);

        return readBoard;
    }

    @Override
    public void modify(PhotoBoard board , Integer boardNo) {

        String checkFileName = board.getFileName();
        if( checkFileName == null ) {
            Optional<PhotoBoard> fileName = repository.findFileName(Long.valueOf(boardNo));
            log.info("fileName is null");
            PhotoBoard photoBoard = fileName.get();
            board.setFileName(photoBoard.getFileName());


        }

            repository.save(board);
    }

    @Override
    public void remove(Integer boardNo) {
        repository.deleteById(Long.valueOf(boardNo));
    }


}
