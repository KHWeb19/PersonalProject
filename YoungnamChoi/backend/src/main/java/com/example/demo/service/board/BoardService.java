package com.example.demo.service.board;

import com.example.demo.entity.board.Board;


import java.util.List;

public interface BoardService {
    public void register (Board board);
    public List<Board> list ();
    public Board read (Integer boardNo);
    public void modify (Board board);
    public void remove (Integer boardNo);
}
