package com.example.demo.utility.board;

import com.example.demo.entitiy.board.videoBoard.VideoBoard;
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



public class BoardServiceImpl {
    //막상하려니 어떻게 해야할지 모르겠다 ㅡ  ㅅ ㅡ ;;
    //생각되로 잘 안되네
    //



 /*
    public void register(Board board,
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


    public List<VideoBoard> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));
    }


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


    public void remove(Integer boardNo) {
        Optional<VideoBoard> findFileName = repository.findFileName(Long.valueOf(boardNo));
        VideoBoard fileName = findFileName.get();
        File file = new File("../../frontend/src/assets/uploadVideo/" + fileName.getFileName());

        if (file.exists()) {
            file.delete();
        }
        repository.deleteById(Long.valueOf(boardNo));
    }*/
}
