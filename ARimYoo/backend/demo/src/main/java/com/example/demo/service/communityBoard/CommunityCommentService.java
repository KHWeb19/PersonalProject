package com.example.demo.service.communityBoard;

import com.example.demo.entity.communityBoard.CommunityCommentBox;

import java.util.List;

public interface CommunityCommentService {

    public void register (Long boardNo, CommunityCommentBox communityComment);
    public List<CommunityCommentBox> list (Long boardNo);
    public void delete (Long commentId);
}
