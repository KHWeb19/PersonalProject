package com.example.backend.service.board;

import com.example.backend.entity.Board;

import java.util.List;

public interface BoardService {

    public void register (Board board);
    public List<Board> list ();
}
