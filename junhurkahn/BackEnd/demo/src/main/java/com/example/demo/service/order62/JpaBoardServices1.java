package com.example.demo.service.order62;


import com.example.demo.entity.jpa.JpaBoards1;

import java.util.List;

public interface JpaBoardServices1 {
    public void register (JpaBoards1 board);
    public List<JpaBoards1> list ();
    public JpaBoards1 read (Integer boardNo);
    public void modify (JpaBoards1 board);
    public void remove (Integer boardNo);

    public List<JpaBoards1> search(String keyword);

}