package com.example.demo.service.jpa.Foreign;

import com.example.demo.entity.jpa.Foreign.ForeignBoard;

import java.util.List;

public interface ForeignBoardService {
    public void register (ForeignBoard board);
    public List<ForeignBoard> list ();
    public ForeignBoard read (Integer boardNo);
    public void modify (ForeignBoard board);
    public void remove (Integer boardNo);
}
