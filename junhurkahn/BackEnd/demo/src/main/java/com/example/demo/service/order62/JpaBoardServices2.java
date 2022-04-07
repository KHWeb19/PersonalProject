package com.example.demo.service.order62;


import com.example.demo.entity.jpa.JpaBoards2;

import java.util.List;

public interface JpaBoardServices2 {
    public void register (JpaBoards2 board);
    public List<JpaBoards2> list ();
    public JpaBoards2 read (Integer boardNo);
    public void modify (JpaBoards2 board);
    public void remove (Integer boardNo);
}