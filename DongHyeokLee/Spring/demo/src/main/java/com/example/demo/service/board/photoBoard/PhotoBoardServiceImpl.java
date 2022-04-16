package com.example.demo.service.board.photoBoard;

import com.example.demo.dto.Board;
import com.example.demo.entitiy.board.photoBoard.PhotoBoard;
import com.example.demo.repository.board.photoBoard.PhotoBoardRepository;

import com.example.demo.service.board.BoardServiceImpl;
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
public class PhotoBoardServiceImpl extends BoardServiceImpl implements PhotoBoardService {

    @Autowired
    private PhotoBoardRepository repository;

    @Override
    public void register(Board board, MultipartFile files) throws Exception {


        String path = "uploadImg";

        fileUpload(board, files, path);

        PhotoBoard photoBoard = PhotoBoard.builder()
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getWriter())
                .fileName(board.getFileName())
                .build();

        repository.save(photoBoard);
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
    public void modify(Integer boardNo, Board board, MultipartFile files) throws Exception {
        log.info(board + " " );

        String path = "uploadImg";

        PhotoBoard photoBoard = PhotoBoard.builder()
                .boardNo(Long.valueOf(boardNo))
                .title(board.getTitle())
                .content(board.getContent())
                .writer(board.getWriter())
                .fileName(board.getFileName())
                .regDate(board.getRegDate())
                .build();

        if(files != null) {
            fileChange(board, files, path);
            fileUpload(board,files,path);
            photoBoard.setFileName(board.getFileName());
        }

        repository.save(photoBoard);
    }

    @Override
    public void remove(Integer boardNo) {
        //파일삭제
        Optional<PhotoBoard> findFileName = repository.findFileName(Long.valueOf(boardNo));
        PhotoBoard photoBoard = findFileName.get();

        String fileName = photoBoard.getFileName();

        String path = "uploadImg";

        fileRemove(fileName, path);
        //db삭제
        repository.deleteById(Long.valueOf(boardNo));
    }

}
