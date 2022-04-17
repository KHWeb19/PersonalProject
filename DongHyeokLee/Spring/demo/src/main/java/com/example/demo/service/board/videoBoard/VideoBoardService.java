package com.example.demo.service.board.videoBoard;

import com.example.demo.entity.board.videoBoard.VideoBoard;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface VideoBoardService {
    public void register(VideoBoard board, MultipartFile file) throws Exception;
    public List<VideoBoard> list ();
    public VideoBoard read (Integer boardNo);
    public void modify (Integer boardNo, VideoBoard board, MultipartFile files) throws Exception;
    public void remove (Integer boardNo);
}
