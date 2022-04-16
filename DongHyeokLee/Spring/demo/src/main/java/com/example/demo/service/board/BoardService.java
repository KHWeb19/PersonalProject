package com.example.demo.service.board;

import com.example.demo.dto.Board;
import com.example.demo.entitiy.board.photoBoard.PhotoBoard;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BoardService {
    public void register(Board board, MultipartFile file) throws Exception;
    public void modify (Integer boardNo, Board board, MultipartFile files) throws Exception;
    public void remove (Integer boardNo);
}
