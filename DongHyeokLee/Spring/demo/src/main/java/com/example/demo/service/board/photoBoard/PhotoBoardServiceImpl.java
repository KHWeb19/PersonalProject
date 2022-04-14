package com.example.demo.service.board.photoBoard;

import com.example.demo.entitiy.board.photoBoard.PhotoBoard;
import com.example.demo.repository.board.photoBoard.PhotoBoardRepository;

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
public class PhotoBoardServiceImpl implements PhotoBoardService {

    @Autowired
    private PhotoBoardRepository repository;

    @Override
    public void register(PhotoBoard board,
                         MultipartFile files) throws Exception {


        if (files != null) {
            UUID uuid = UUID.randomUUID();

            String fileName = uuid + "_" + files.getOriginalFilename();
            FileOutputStream saveFile = new FileOutputStream(
                    "../../frontend/src/assets/uploadImg/" + fileName);

            saveFile.write(files.getBytes());
            saveFile.close();

            board.setFileName(fileName);

        }

        repository.save(board);
    }


    @Override
    public List<PhotoBoard> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));
    }

    @Override
    public PhotoBoard read(Integer boardNo) {
        Optional<PhotoBoard> maybeReadBoard = repository.findById(Long.valueOf(boardNo));

        if (maybeReadBoard.equals(Optional.empty())) {
            log.info("Can't read board!!");
            return null;
        }

        PhotoBoard readBoard = maybeReadBoard.get();
        readBoard.setCount(readBoard.getCount() + 1);
        repository.save(readBoard);

        return readBoard;
    }


    @Override
    public void modify(Integer boardNo, PhotoBoard board, MultipartFile files) throws Exception {
        log.info(board + " " );

        if( files != null) {

            File file = new File("../../frontend/src/assets/uploadImg/" + board.getFileName());

            if (file.exists()) {
                file.delete();
            }

        }
        register(board, files);
    }

    @Override
    public void remove(Integer boardNo) {
        //파일삭제
        Optional<PhotoBoard> findFileName = repository.findFileName(Long.valueOf(boardNo));
        PhotoBoard fileName = findFileName.get();
        File file = new File("../../frontend/src/assets/uploadImg/" + fileName.getFileName());

        if (file.exists()) {
            file.delete();
        }
        //db삭제
        repository.deleteById(Long.valueOf(boardNo));
    }

}
