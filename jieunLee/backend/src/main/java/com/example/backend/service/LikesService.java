package com.example.backend.service;


import com.example.backend.entity.Board;
import com.example.backend.entity.Comment;
import com.example.backend.entity.Likes;

public interface LikesService {
    public boolean register (Long boardNo, Long memberNo);
//    public void remove (Integer likesNo);
}
