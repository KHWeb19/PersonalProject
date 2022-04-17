package com.example.demo.service.board.photoBoard;

import com.example.demo.dto.LikeRequest;
import com.example.demo.entity.board.photoBoard.PhotoBoard;
import com.example.demo.entity.board.photoBoard.PhotoBoardLike;
import com.example.demo.service.board.BoardService;


import java.util.List;

public interface PhotoBoardService extends BoardService {
       public List<PhotoBoard> list (String writer);
       public PhotoBoard read (Integer boardNo);
       public void doLike(LikeRequest like);
       public void unDoLike(LikeRequest like);


}
