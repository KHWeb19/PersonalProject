package com.example.backend.service.board;

import com.example.backend.entity.Board;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface BoardService {

    public void register (Board board) throws Exception;
    public List<Board> list ();
    public Board read (Long boardNo);
    public void modify (Board board, Long boardNo) throws Exception;
    public void remove (Integer boardNo) ;
}
