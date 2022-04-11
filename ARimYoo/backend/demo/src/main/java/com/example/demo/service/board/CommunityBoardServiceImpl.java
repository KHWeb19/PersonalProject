package com.example.demo.service.board;

import com.example.demo.entity.board.CommunityBoard;
import com.example.demo.repository.board.CommunityBoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class CommunityBoardServiceImpl implements CommunityBoardService {

    @Autowired
    CommunityBoardRepository repository;

    @Override
    public void register(CommunityBoard board, @RequestParam(required = false) MultipartFile file) throws Exception {

        if (file != null) {
            UUID uuid = UUID.randomUUID();
            String fileName = uuid + "_" + file.getOriginalFilename();
            FileOutputStream saveFile = new FileOutputStream("../../frontend/src/assets/back/" + fileName);

            saveFile.write(file.getBytes());
            saveFile.close();

            board.setFileName(fileName);
            board.setFilePath("/files/" + fileName);
        }

        repository.save(board);
    }

    @Override
    public List<CommunityBoard> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));

    }

    @Override
    public CommunityBoard read(Long boardNo) {
        Optional<CommunityBoard> maybeReadBoard = repository.findById(Long.valueOf(boardNo));

        if (maybeReadBoard.equals(Optional.empty())) {
            log.info("Can't read board!");
            return null;
        } else {
            CommunityBoard communityBoard = maybeReadBoard.get();
            communityBoard.increaseViewCnt();
            repository.save(communityBoard);
            return maybeReadBoard.get();
        }
    }

    @Override
    public void modify(CommunityBoard communityBoard, @RequestParam(required = false) MultipartFile file) throws Exception {
        log.info(communityBoard.getFileName());

        if (communityBoard.getFileName().equals(Optional.empty())) {
            Path filePath = Paths.get("c:\\khweb19\\PersonalProject\\ARimYoo\\frontend\\src\\assets\\back\\" + communityBoard.getFileName());
            Files.delete(filePath);
        }

        if (file != null) {

            UUID uuid = UUID.randomUUID();
            String fileName = uuid + "_" + file.getOriginalFilename();
            FileOutputStream saveFile = new FileOutputStream("../../frontend/src/assets/back/" + fileName);

            saveFile.write(file.getBytes());
            saveFile.close();

            communityBoard.setFileName(fileName);
            communityBoard.setFilePath("/files/" + fileName);
        }

        repository.save(communityBoard);
    }

    @Override
    public void remove(Integer boardNo) throws Exception {
        Optional<CommunityBoard> selectFile = repository.findById(Long.valueOf(boardNo));
        CommunityBoard deleteFile = selectFile.get();
        System.out.println(deleteFile.getFileName());

        if (deleteFile.getFileName() != null) {
            Path filePath = Paths.get("c:\\khweb19\\PersonalProject\\ARimYoo\\frontend\\src\\assets\\back\\" + deleteFile.getFileName());
            Files.delete(filePath);
        }

        repository.deleteById(Long.valueOf(boardNo));
    }


}
