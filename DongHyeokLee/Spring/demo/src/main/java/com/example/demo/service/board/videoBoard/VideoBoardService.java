package com.example.demo.service.board.videoBoard;

import com.example.demo.entitiy.board.photoBoard.PhotoBoard;
import com.example.demo.entitiy.board.videoBoard.VideoBoard;

import java.util.List;

public interface VideoBoardService {
    public void register (VideoBoard photoBoard);
    public List<VideoBoard> list ();
    public VideoBoard read (Integer boardNo);
    public void modify (VideoBoard board,Integer boardNo);
    public void remove (Integer boardNo);
}
