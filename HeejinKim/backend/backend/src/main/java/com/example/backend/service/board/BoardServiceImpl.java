package com.example.backend.service.board;

import com.example.backend.entity.Board;
import com.example.backend.repository.Board.BoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Slf4j
@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    BoardRepository repository;

    @Override
    public void register(Board board, @RequestParam(required = false) MultipartFile file) throws Exception {

        if (file != null) {


            UUID uuid = UUID.randomUUID();
            String fileName = uuid + "_" +file.getOriginalFilename();

            FileOutputStream saveFile = new FileOutputStream("../../frontend/frontend_pro/src/assets/uploadImg/" + fileName);

            saveFile.write(file.getBytes());
            saveFile.close();

            board.setFileName(fileName);
        }

        repository.save(board);
    }

    @Override
    public void modify(Board board,  @RequestParam(required = false) MultipartFile file) throws Exception {

        if (board.getFileName().equals(Optional.empty())) {

            Path filePath = Paths.get("c:\\PersonalProject\\PersonalProject-1\\HeejinKim\\frontend\\frontend_pro\\src\\assets\\uploadImg\\" + board.getFileName());
            Files.delete(filePath);
        }

        if (file != null) {

            UUID uuid = UUID.randomUUID();

            String fileName =  uuid + "_" + file.getOriginalFilename();
            FileOutputStream saveFile = new FileOutputStream("../../frontend/frontend_pro/src/assets/uploadImg/" + fileName);

            saveFile.write(file.getBytes());
            saveFile.close();

            board.setFileName(fileName);
        }

        repository.save(board);
    }




    @Override
    public List<Board> list() {

        return repository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));

    }

    @Override
    public Board read(Long boardNo) {

        Optional<Board> maybeReadBoard = repository.findById(Long.valueOf(boardNo));
        if (maybeReadBoard.equals(Optional.empty())) {
            log.info("Can't read board!");
            return null;

        } else {
            Board board = maybeReadBoard.get();
            repository.save(board);
            return maybeReadBoard.get();
        }
    }

    @Override
    public void remove(Integer boardNo) {

        Optional<Board> selectFile = repository.findById(Long.valueOf(boardNo));
        Board deleteFile = selectFile.get();

        File file = new File("../../frontend_pro/src/assets/uploadImg/" + deleteFile.getFileName());


        if ( file.exists()) {

            file.delete();
        }

        repository.deleteById(Long.valueOf(boardNo));
    }
    @Override
    public List<Board> searchList(String keyWord) {
        List<Board> findSearchList = repository.findByTitleContaining(keyWord);

        return findSearchList;
    }
}
