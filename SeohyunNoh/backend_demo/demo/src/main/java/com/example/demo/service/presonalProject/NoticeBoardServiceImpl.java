package com.example.demo.service.presonalProject;

import com.example.demo.entity.personalProject.NoticeBoard;
import com.example.demo.repository.personalProject.NoticeBoardRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class NoticeBoardServiceImpl implements NoticeBoardService {

    @Autowired
    NoticeBoardRepository noticeRepository;

    @Override
    public void register(NoticeBoard noticeBoard) {
        noticeRepository.save(noticeBoard);
    }

    @Override
    public List<NoticeBoard> list() {
        return noticeRepository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));
    }

    @Override
    public NoticeBoard read(Integer boardNo) {
        Optional<NoticeBoard> maybeReadBoard = noticeRepository.findById(Long.valueOf(boardNo));

        if(maybeReadBoard.equals(Optional.empty())) {
            log.info("Cannot read notice board");
            return null;
        }
        return maybeReadBoard.get();
    }

    @Override
    public void modify(NoticeBoard noticeBoard) {
        noticeRepository.save(noticeBoard);
    }

    @Override
    public void remove(Integer boardNo) {
        noticeRepository.deleteById(Long.valueOf(boardNo));
    }
}
