package com.example.demo.service.order62;


import com.example.demo.entity.jpa.JpaBoards4;

import java.util.List;

public interface JpaBoardServices4 {
    public void register (JpaBoards4 board);
    public List<JpaBoards4> list ();
    public JpaBoards4 read (Integer boardNo);
    public void modify (JpaBoards4 board);
    public void remove (Integer boardNo);
}