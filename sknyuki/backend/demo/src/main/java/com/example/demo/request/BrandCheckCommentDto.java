package com.example.demo.request;

import com.example.demo.entity.BrandCheckComment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BrandCheckCommentDto {
    private Long commentNo;
    private String id;
    private String content;
    private Long boardNo;
    private Date regDate;
    private Date updDate;

    public BrandCheckComment toEntity() {
        return BrandCheckComment.builder()
                .commentNo(commentNo)
                .id(id)
                .content(content)
                .boardNo(boardNo)
                .regDate(regDate)
                .updDate(updDate)
                .build();
    }

}
