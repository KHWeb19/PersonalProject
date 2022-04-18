package com.example.demo.service.board.photoBoard;

import com.example.demo.dto.response.PhotoBoardResponse;
import com.example.demo.service.board.BoardService;

import java.util.List;

public interface PhotoBoardService extends BoardService {
    public List<PhotoBoardResponse> list();
    public PhotoBoardResponse read(Integer boardNo);
}
