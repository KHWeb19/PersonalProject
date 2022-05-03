package com.example.demo.dto.response;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@Data
public class CommentResponse {
    private String writer;
    private String comment;
    private Long boardNo;
    private Date regDate;
    private Long commentNo;
    private Long parCommentNo;


    public CommentResponse(String writer, String comment, Long boardNo, Date regDate, Long commentNo, Long parCommentNo){
        this.writer = writer;
        this.comment = comment;
        this.boardNo = boardNo;
        this.regDate = regDate;
        this.commentNo = commentNo;
        this.parCommentNo = parCommentNo;
    }


}
