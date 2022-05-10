package com.example.demo.controller.request;

import com.example.demo.entity.personalProject.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private Long commentNo;
    private Long qnaNo;
    private String id;
    private String content;
    private Date regDate;
    private Date updDate;

    public Comment toEntity() {
        return Comment.builder()
                .commentNo(commentNo)
                .id(id)
                .content(content)
                .qnaNo(qnaNo)
                .regDate(regDate)
                .updDate(updDate)
                .build();
    }
}
