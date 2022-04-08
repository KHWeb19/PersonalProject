package com.example.demo.service.board.videoBoard;

import com.example.demo.entitiy.board.photoBoard.PhotoBoard;
import com.example.demo.entitiy.board.videoBoard.VideoBoard;
import com.example.demo.repository.board.photoBoard.PhotoBoardRepository;
import com.example.demo.repository.board.videoBoard.VideoBoardRepository;
import com.example.demo.service.board.photoBoard.PhotoBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Slf4j
@Service
public class VideoBoardServiceImpl implements VideoBoardService {

    @Autowired
    private VideoBoardRepository repository;

    @Override
    public void register(VideoBoard videoBoard) {
            repository.save(videoBoard);

    }

    @Override
    public List<VideoBoard> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));
    }

    @Override
    public VideoBoard read(Integer boardNo) {
        Optional<VideoBoard> maybeReadBoard = repository.findById(Long.valueOf(boardNo));

        if (maybeReadBoard.equals(Optional.empty())){
            log.info("Can't read board!!");
            return null;
        }
        log.info("readCheck" + maybeReadBoard.get());
        return maybeReadBoard.get();
    }

    @Override
    public void modify(VideoBoard board , Integer boardNo) {

        String checkFileName = board.getFileName();
        if( checkFileName == null ) {
            Optional<VideoBoard> fileName = repository.findFileName(Long.valueOf(boardNo));
            log.info("fileName is null");
            VideoBoard videoBoard = fileName.get();
            board.setFileName(videoBoard.getFileName());


        }

            repository.save(board);
    }

    @Override
    public void remove(Integer boardNo) {
        repository.deleteById(Long.valueOf(boardNo));
    }


}
