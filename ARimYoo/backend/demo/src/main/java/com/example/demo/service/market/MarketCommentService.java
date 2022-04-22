package com.example.demo.service.market;

import com.example.demo.entity.market.MarketComment;

import java.util.List;

public interface MarketCommentService {

    public void register (Long boardNo, MarketComment marketComment);
    public List<MarketComment> list (Long boardNo);
    public void delete (Long commentId);
}
