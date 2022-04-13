package com.example.backend.service;

import com.example.backend.entity.Board;

import java.util.List;

public interface BoardService {
    public void register (Board board);
    public List<Board> list ();
//    public List<Board> myList (String writer);
    public Board read (Integer boardNo);
    public void modify (Board board);
    public void remove (Integer boardNo);
}
