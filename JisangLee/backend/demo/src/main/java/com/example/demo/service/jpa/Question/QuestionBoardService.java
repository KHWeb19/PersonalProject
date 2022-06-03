package com.example.demo.service.jpa.Question;

import com.example.demo.entity.jpa.Local.LocalBoard;
import com.example.demo.entity.jpa.Question.QuestionBoard;

import java.util.List;

public interface QuestionBoardService {
    public void register (QuestionBoard board);
    public List<QuestionBoard> list ();
    public QuestionBoard read (Integer boardNo);
    public void modify (QuestionBoard board);
    public void remove (Integer boardNo);
}
