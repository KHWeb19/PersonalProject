package com.example.demo.service;


import com.example.demo.entity.BasketBoard;

import java.util.List;

public interface BasketBoardService {
    public void register (BasketBoard productboard);
    public BasketBoard read (Integer boardNo);
    public void modify (BasketBoard board);
    public void remove (Integer boardNo);
    List<BasketBoard> userRead(String id) throws Exception;
}
