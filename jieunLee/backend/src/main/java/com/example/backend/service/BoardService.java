package com.example.backend.service;

import com.example.backend.controller.BoardRequest;
import com.example.backend.controller.CommentRequest;
import com.example.backend.controller.MemberRequest;
import com.example.backend.entity.Board;

import java.util.List;

public interface BoardService {
    public void register (Integer memberNo, Board board);
    public List<Board> list ();
    List<Board> followBoardList (Long memberNo);
    List<Board> memberBoardList (Long memberNo);
    public Board read (Integer boardNo);
    public void modify (Board board, Integer memberNo);
    public void remove (Long boardNo);
}
