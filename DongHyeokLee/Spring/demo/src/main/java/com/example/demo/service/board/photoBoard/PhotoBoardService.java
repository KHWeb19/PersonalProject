package com.example.demo.service.board.photoBoard;

import com.example.demo.entitiy.board.photoBoard.PhotoBoard;
import com.example.demo.service.board.BoardService;


import java.util.List;

public interface PhotoBoardService extends BoardService {
       public List<PhotoBoard> list ();
       public PhotoBoard read (Integer boardNo);

}
