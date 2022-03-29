package com.example.demo.service.freeBoard;

import com.example.demo.entitiy.freeBoard.FreeBoard;

import java.util.List;

public interface FreeBoardService {
        public void register (FreeBoard freeBoard);
        public List<FreeBoard> list ();
}
