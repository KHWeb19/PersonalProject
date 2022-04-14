package com.example.demo.service.board.photoBoard;

import com.example.demo.entitiy.board.photoBoard.PhotoBoard;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface PhotoBoardService {
    public void register(PhotoBoard board,  MultipartFile file) throws Exception;
    public List<PhotoBoard> list ();
    public PhotoBoard read (Integer boardNo);
    public void modify (Integer boardNo, PhotoBoard board, MultipartFile files) throws Exception;
    public void remove (Integer boardNo);
}
