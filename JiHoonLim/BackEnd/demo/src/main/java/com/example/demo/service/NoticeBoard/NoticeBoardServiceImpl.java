package com.example.demo.service.NoticeBoard;

import com.example.demo.entity.NoticeBoard.NoticeBoard;
import com.example.demo.repository.NoticeBoard.NoticeBoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class NoticeBoardServiceImpl implements NoticeBoardService{

    @Autowired
    NoticeBoardRepository repository;

    @Override
    public void register(NoticeBoard noticeBoard) {
        repository.save(noticeBoard);
    }

    @Override
    public List<NoticeBoard> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC,"boardNo"));
    }

    @Override
    public NoticeBoard read(Long boardNo) {
        Optional<NoticeBoard> maybeBoard = repository.findById((boardNo));

        if (maybeBoard.equals(Optional.empty())){
            log.info("No board");
            return null;
        }

        return maybeBoard.get();
    }

    @Override
    public void modify(NoticeBoard noticeBoard) {
        repository.save(noticeBoard);
    }

    @Override
    public void remove(Long boardNo) {
        repository.deleteById(boardNo);
    }

    @Override
    public void updateViewCount(Long boardNo) {
        repository.updateViewCount(boardNo);
    }
}
