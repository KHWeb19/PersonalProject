package com.example.backend.service;


import com.example.backend.entity.Board;
import com.example.backend.entity.Comment;
import com.example.backend.entity.Likes;

public interface LikesService {
    public void register (Integer boardNo, Integer memberNo, Likes likes);
    public void remove (Integer likesNo);
}
