package com.example.demo.service.board.videoBoard;

import com.example.demo.entity.board.videoBoard.VideoBoard;
import com.example.demo.repository.board.videoBoard.VideoBoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Slf4j
@Service
public class VideoBoardServiceImpl implements VideoBoardService {

    @Autowired
    private VideoBoardRepository repository;


    @Override
    public void register(VideoBoard board,
                         MultipartFile files) throws Exception {

        if (files != null) {
            UUID uuid = UUID.randomUUID();

            String fileName = uuid + "_" + files.getOriginalFilename();
            FileOutputStream saveFile = new FileOutputStream(
                    "../../frontend/src/assets/uploadVideo/" + fileName);

            saveFile.write(files.getBytes());
            saveFile.close();

            board.setFileName(fileName);
        }
        repository.save(board);
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
        VideoBoard readBoard = maybeReadBoard.get();
        readBoard.setCount(readBoard.getCount()+1);
        repository.save(readBoard);

        return readBoard;
    }

    @Override
    public void modify(Integer boardNo, VideoBoard board, MultipartFile files) throws Exception {
        log.info(board + " " );

        if( files != null) {

            File file = new File("../../frontend/src/assets/uploadVideo/" + board.getFileName());

            if (file.exists()) {
                file.delete();
            }
        }
        register(board, files);
    }

    @Override
    public void remove(Integer boardNo) {
        Optional<VideoBoard> findFileName = repository.findFileName(Long.valueOf(boardNo));
        VideoBoard fileName = findFileName.get();
        File file = new File("../../frontend/src/assets/uploadVideo/" + fileName.getFileName());

        if (file.exists()) {
            file.delete();
        }
        repository.deleteById(Long.valueOf(boardNo));
    }


}
