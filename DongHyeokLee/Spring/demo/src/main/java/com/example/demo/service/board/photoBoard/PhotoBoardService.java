package com.example.demo.service.board.photoBoard;

import com.example.demo.dto.BoardResponse;
import com.example.demo.dto.LikeRequest;
import com.example.demo.entity.board.photoBoard.PhotoBoard;
import com.example.demo.service.board.BoardService;


import java.util.List;

public interface PhotoBoardService extends BoardService {
       public  List<BoardResponse> list ();
       public BoardResponse read (Integer boardNo);
       public void doLike(LikeRequest like);
       public void unDoLike(LikeRequest like);


}
