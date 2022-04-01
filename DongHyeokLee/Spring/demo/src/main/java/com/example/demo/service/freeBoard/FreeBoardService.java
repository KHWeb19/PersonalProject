package com.example.demo.service.freeBoard;

import com.example.demo.entitiy.freeBoard.FreeBoard;

import java.util.List;

public interface FreeBoardService {
        public void register (FreeBoard freeBoard);
        public List<FreeBoard> list ();
        public FreeBoard read (Integer boardNo);
        public void modify (FreeBoard board);
        public void remove (Integer boardNo);
}
