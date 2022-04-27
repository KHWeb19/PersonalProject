package com.example.demo.service;


import com.example.demo.entity.ProductBoardB;

import java.util.List;

public interface ProductBoardBService {
    public void register (ProductBoardB productboard);
    public List<ProductBoardB> list ();
    public ProductBoardB read (Integer boardNo);
    public void modify (ProductBoardB board);
    public void remove (Integer boardNo);
    List<ProductBoardB> userRead(String id) throws Exception;
}
