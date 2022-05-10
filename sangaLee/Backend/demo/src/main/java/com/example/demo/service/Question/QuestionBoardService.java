package com.example.demo.service.Question;

import com.example.demo.entity.QuestionBoard;

import java.util.List;

public interface QuestionBoardService {
    public void register (QuestionBoard board);
    public List<QuestionBoard> list ();
    public QuestionBoard read (Integer boardNo);
    public void modify (QuestionBoard board);
    public void remove (Integer boardNo);
}
