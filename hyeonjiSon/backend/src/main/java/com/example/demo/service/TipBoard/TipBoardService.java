package com.example.demo.service.TipBoard;

import com.example.demo.entity.TipBoard;

import java.util.List;

public interface TipBoardService {
    public void register (TipBoard board);
    public List<TipBoard> list ();
    public TipBoard read (Integer boardNo);
    public void modify (TipBoard board);
    public void remove (Integer boardNo);
}
