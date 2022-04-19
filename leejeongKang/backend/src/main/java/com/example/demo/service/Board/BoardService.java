package com.example.demo.service.Board;

import com.example.demo.entity.Board.Board;

import java.util.List;

public interface BoardService {
    public void register (Board board);
    public List<Board> list();
    public Board read (Integer boardNo);
    public void modify (Board boardNo);
    public void remove (Long boardNo);

}
