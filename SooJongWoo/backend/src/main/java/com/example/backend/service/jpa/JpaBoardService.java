package com.example.backend.service.jpa;

import com.example.backend.entity.jpa.Board;

import java.util.List;

public interface JpaBoardService {
    public void register(Board board) throws Exception;

    public Board read(Long boardNo) throws Exception;

    public void remove(Long boardNo) throws Exception;

    public List<Board> list() throws Exception;
}
