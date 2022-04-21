package com.example.demo.service.presonalProject;

import com.example.demo.entity.personalProject.NoticeBoard;
import com.example.demo.entity.personalProject.QnABoard;

import java.util.List;

public interface QnAService {
    public void register(QnABoard qnABoard);
    public List<QnABoard> list();
    public QnABoard read(Integer qnaNo);
    public void modify(QnABoard qnABoard);
    public void remove(Integer qnaNo);
    public List<QnABoard> userRead(String id) throws Exception;
}
