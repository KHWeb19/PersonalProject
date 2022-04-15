package com.example.demo.service.StoreBoard;

import com.example.demo.entity.StoreBoard;

import java.util.List;

public interface StoreBoardService {
    public void register (StoreBoard board);
    public List<StoreBoard> list ();
}
