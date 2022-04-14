package com.example.demo.utility.board;

import com.example.demo.entitiy.board.videoBoard.VideoBoard;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BoardService {
   public void register(Object board, MultipartFile file) throws Exception;
    public List<Object> list ();
    public VideoBoard read (Integer boardNo);
    public void modify (Integer boardNo, Object board, MultipartFile files) throws Exception;
    public void remove (Integer boardNo);
}
