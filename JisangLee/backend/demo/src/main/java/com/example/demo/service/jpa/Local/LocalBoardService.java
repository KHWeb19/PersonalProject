package com.example.demo.service.jpa.Local;

import com.example.demo.entity.jpa.Local.LocalBoard;

import java.util.List;

public interface LocalBoardService {
    public void register (LocalBoard board);
    public List<LocalBoard> list ();
    public LocalBoard read (Integer boardNo);
    public void modify (LocalBoard board);
    public void remove (Integer boardNo);
}
