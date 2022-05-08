package com.example.backend.service.serviceCenter;

import com.example.backend.controller.board.request.CommentRequest;
import com.example.backend.controller.serviceBoard.CenterCommentRequest;
import com.example.backend.entity.BoardComments;
import com.example.backend.entity.CenterComments;

import java.util.List;

public interface CenterCommentsService {
    public void register (Integer centerNo, CenterCommentRequest centerCommentRequest);
    public List<CenterComments> list (Integer centerNo);
    public CenterComments modify (Integer comNo, CenterCommentRequest centerCommentRequest);
    public void remove (Integer comNo);

}
