package com.example.demo.service.order62;


import com.example.demo.entity.jpa.JpaBoards;

import java.util.List;

public interface JpaBoardServices {
    public void register (JpaBoards board);
    public List<JpaBoards> list ();
    public JpaBoards read (Integer boardNo);
    public void modify (JpaBoards board);
    public void remove (Integer boardNo);
}
