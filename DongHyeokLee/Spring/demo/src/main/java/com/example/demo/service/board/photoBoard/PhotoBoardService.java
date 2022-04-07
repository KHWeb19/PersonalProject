package com.example.demo.service.board.photoBoard;

import com.example.demo.entitiy.board.freeBoard.FreeBoard;
import com.example.demo.entitiy.board.photoBoard.PhotoBoard;

import java.util.List;

public interface PhotoBoardService {
    public void register (PhotoBoard photoBoard);
    public List<PhotoBoard> list ();
    public PhotoBoard read (Integer boardNo);
}
