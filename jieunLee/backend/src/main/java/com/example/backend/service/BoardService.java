package com.example.backend.service;

import com.example.backend.controller.BoardRequest;
import com.example.backend.controller.CommentRequest;
import com.example.backend.entity.Board;

import java.util.List;

public interface BoardService {
    public void register (Integer memberNo, Board board);
    public List<Board> list ();
    List<Board> memberBoardList (Integer memberNo);
    public Board read (Integer boardNo);
    public void modify (Board board);
    public void remove (Integer boardNo);
}
