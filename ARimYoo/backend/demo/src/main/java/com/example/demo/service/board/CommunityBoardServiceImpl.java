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
import java.io.IOException;
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
        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files";

        if (file != null) {
            UUID uuid = UUID.randomUUID();
            String fileName = uuid + "_" + file.getOriginalFilename();
            File saveFile = new File(projectPath, fileName);

            file.transferTo(saveFile);

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
    public void modify(CommunityBoard communityBoard) {
        repository.save(communityBoard);
    }

    @Override
    public void remove(Integer boardNo) {
        repository.deleteById(Long.valueOf(boardNo));
    }


}
