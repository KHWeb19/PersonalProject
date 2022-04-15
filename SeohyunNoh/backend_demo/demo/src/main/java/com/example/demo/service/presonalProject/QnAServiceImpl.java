package com.example.demo.service.presonalProject;

import com.example.demo.entity.personalProject.NoticeBoard;
import com.example.demo.entity.personalProject.QnABoard;
import com.example.demo.repository.personalProject.NoticeBoardRepository;
import com.example.demo.repository.personalProject.QnARepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class QnAServiceImpl implements QnAService {

    @Autowired
    QnARepository qnaRepository;

    @Override
    public void register(QnABoard qnABoard) {
        qnaRepository.save(qnABoard);
    }

    @Override
    public List<QnABoard> list() {
        return qnaRepository.findAll(Sort.by(Sort.Direction.DESC, "qnaNo"));
    }

    @Override
    public QnABoard read(Integer qnaNo) {
        Optional<QnABoard> maybeReadQnA = qnaRepository.findById(Long.valueOf(qnaNo));

        if(maybeReadQnA.equals(Optional.empty())) {
            log.info("Cannot read Q&A board");
            return null;
        }
        return maybeReadQnA.get();
    }

    @Override
    public void modify(QnABoard qnABoard) {
        qnaRepository.save(qnABoard);
    }

    @Override
    public void remove(Integer qnaNo) {
        qnaRepository.deleteById(Long.valueOf(qnaNo));
    }
}
