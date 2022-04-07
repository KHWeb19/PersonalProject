package com.example.demo.service.order62;


import com.example.demo.entity.jpa.JpaBoards3;

import java.util.List;

public interface JpaBoardServices3 {
    public void register (JpaBoards3 board);
    public List<JpaBoards3> list ();
    public JpaBoards3 read (Integer boardNo);
    public void modify (JpaBoards3 board);
    public void remove (Integer boardNo);
}