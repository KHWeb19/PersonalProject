package com.example.demo.service.board;

import com.example.demo.dto.BoardRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BoardService {
    public void register(BoardRequest board, MultipartFile file) throws Exception;
    public void modify (Integer boardNo, BoardRequest board, MultipartFile files) throws Exception;
    public void remove (Integer boardNo);

}
