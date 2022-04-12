package com.example.demo.service.board.freeBoard;

import com.example.demo.entitiy.board.freeBoard.FreeBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FreeBoardService {
        public void register (FreeBoard freeBoard);
        //public Page<FreeBoard> list (PageRequest pageRequest);
        public List<FreeBoard> list();
        public FreeBoard read (Integer boardNo);
        public void modify (FreeBoard board);
        public void remove (Integer boardNo);
        public List<FreeBoard> searchList(String searchWord);
}
