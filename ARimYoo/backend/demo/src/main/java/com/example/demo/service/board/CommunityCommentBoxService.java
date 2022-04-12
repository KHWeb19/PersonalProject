package com.example.demo.service.board;

import com.example.demo.entity.board.CommunityCommentBox;

import java.util.List;

public interface CommunityCommentBoxService {

    public void register (Long boardNo, CommunityCommentBox communityCommentBox);
    public List<CommunityCommentBox> list (Long boardNo);
    public void delete (Long commentId);
}
