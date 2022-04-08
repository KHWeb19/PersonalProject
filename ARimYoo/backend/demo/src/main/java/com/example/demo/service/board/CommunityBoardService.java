package com.example.demo.service.board;

import com.example.demo.entity.board.CommunityBoard;

import java.util.List;

public interface CommunityBoardService {

    public void register (CommunityBoard board);
    public List<CommunityBoard> list ();
    public CommunityBoard read (Integer boardNo);
}
