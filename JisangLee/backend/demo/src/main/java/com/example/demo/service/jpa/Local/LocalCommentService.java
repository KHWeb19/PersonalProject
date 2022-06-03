package com.example.demo.service.jpa.Local;

import com.example.demo.entity.jpa.Local.LocalComment;

import java.util.List;

public interface LocalCommentService {
    public void register (Integer boardNo, LocalComment localComment);
    public List<LocalComment> list (Integer boardNo);
    public void delete (Long commentId);
}


