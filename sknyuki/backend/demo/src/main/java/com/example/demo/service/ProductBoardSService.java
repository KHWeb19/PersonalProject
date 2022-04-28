package com.example.demo.service;


import com.example.demo.entity.ProductBoardS;

import java.util.List;

public interface ProductBoardSService {
    public void register (ProductBoardS productboard);
    public List<ProductBoardS> list ();
    public ProductBoardS read (Integer boardNo);
    public void modify (ProductBoardS board);
    public void remove (Integer boardNo);
    List<ProductBoardS> userRead(String id) throws Exception;
}
