package com.example.demo.service;

import com.example.demo.entity.BrandCheckBoard;


import java.util.List;

public interface BrandCheckBoardService {
    public void register (BrandCheckBoard board);
    public List<BrandCheckBoard> list ();
    public BrandCheckBoard read (Integer boardNo);
    public void modify (BrandCheckBoard board);
    public void remove (Integer boardNo);
}
