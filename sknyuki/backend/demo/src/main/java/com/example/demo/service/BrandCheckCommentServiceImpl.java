package com.example.demo.service;

import com.example.demo.entity.BrandCheckComment;
import com.example.demo.repository.BrandCheckCommentRepository;
import com.example.demo.request.BrandCheckCommentDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Lazy
@Slf4j
public class BrandCheckCommentServiceImpl implements BrandCheckCommentService {
    @Autowired
    BrandCheckCommentRepository repository;

    @Override
    public BrandCheckComment add(BrandCheckCommentDto brandcheckCommentDto) throws Exception {
        BrandCheckComment brandcheckComment = repository.save(brandcheckCommentDto.toEntity());

        return brandcheckComment;
    }

    @Override
    public List<BrandCheckComment> read(Long boardNo) throws Exception {
        List<BrandCheckComment> brandCheckComments = repository.findByBoardNo(boardNo);

        return brandCheckComments;
    }

    @Override
    public BrandCheckComment readOnly(Long commentNo) throws Exception {
        BrandCheckComment brandcheckComment = repository.findById(commentNo).orElseThrow();

        return brandcheckComment;
    }

    @Override
    public void modify(BrandCheckComment brandcheckComment, BrandCheckCommentDto brandcheckCommentDto) throws Exception {
        brandcheckComment.updateContent(brandcheckCommentDto);

        repository.save(brandcheckComment);
    }

    @Override
    public void remove(BrandCheckComment brandcheckComment) throws Exception {
        repository.delete(brandcheckComment);
    }
}
