package com.example.backend.service;

import com.example.backend.entity.Likes;

import java.util.List;

public interface LikesService {
    public boolean register (Long boardNo, Long memberNo, Likes likes);
    Likes likes (Long boardNo, Long memberNo);
    List<Likes> list (Long boardNo);
    List<Likes> myLikes (Long memberNo);
}
