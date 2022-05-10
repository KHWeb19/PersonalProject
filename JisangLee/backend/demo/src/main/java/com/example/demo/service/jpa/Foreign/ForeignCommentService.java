package com.example.demo.service.jpa.Foreign;

import com.example.demo.entity.jpa.Foreign.ForeignComment;

import java.util.List;

public interface ForeignCommentService {
    public void register (Integer boardNo, ForeignComment foreignComment);
    public List<ForeignComment> list (Integer boardNo);
    public void delete (Long commentId);
}


