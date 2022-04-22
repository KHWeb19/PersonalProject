package com.example.backend.service;


import com.example.backend.entity.Board;
import com.example.backend.entity.Comment;
import com.example.backend.entity.Likes;

import java.util.List;

public interface LikesService {
    public boolean register (Long boardNo, Long memberNo, Likes likes);
    List<Likes> list (Long boardNo, Long memberNo);
//    public void remove (Integer likesNo);
}
