package com.example.demo.service;

import com.example.demo.entity.BrandCheckComment;
import com.example.demo.request.BrandCheckCommentDto;

import java.util.List;

public interface BrandCheckCommentService {
    BrandCheckComment add(BrandCheckCommentDto brandcheckCommentDto) throws Exception;
    List<BrandCheckComment> read(Long boardNo) throws Exception;
    BrandCheckComment readOnly(Long commentNo) throws Exception;
    void modify(BrandCheckComment recommendComment, BrandCheckCommentDto brandcheckCommentDto) throws Exception;
    void remove(BrandCheckComment recommendComment) throws Exception;

}
