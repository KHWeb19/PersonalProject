package com.example.demo.service.board;

import com.example.demo.dto.BoardRequest;
import com.example.demo.dto.BoardResponse;
import com.example.demo.dto.LikeRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BoardService {
    public void register(BoardRequest board, MultipartFile file) throws Exception;
    public void modify (Integer boardNo, BoardRequest board, MultipartFile files) throws Exception;
    public void remove (Integer boardNo);
    public  List<BoardResponse>list();
    public BoardResponse read (Integer boardNo);
    public void doLike(LikeRequest like);
    public void unDoLike(LikeRequest like);
    public void likeCheck(String writer);


}
