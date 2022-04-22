package com.example.demo.service.personalProject;

import com.example.demo.entity.personalProject.NoticeBoard;

import java.util.List;

public interface NoticeBoardService {
    public void register(NoticeBoard noticeBoard);
    public List<NoticeBoard> list();
    public NoticeBoard read(Integer boardNo);
    public void modify(NoticeBoard noticeBoard);
    public void remove(Integer boardNo);
}
