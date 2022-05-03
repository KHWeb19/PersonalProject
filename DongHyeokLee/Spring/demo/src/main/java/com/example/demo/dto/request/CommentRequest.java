package com.example.demo.dto.request;


import com.example.demo.entity.board.freeBoard.FreeBoardComments;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
public class CommentRequest {
    private String writer;
    private String comment;
    private Long boardNo;
    private Date regDate;
    private FreeBoardComments freeBoardComment;


    public CommentRequest(String writer, String comment, Long boardNo, Date regDate, FreeBoardComments freeBoardComment) {
        this.writer = writer;
        this.comment = comment;
        this.boardNo = boardNo;
        this.regDate = regDate;
        this.freeBoardComment = freeBoardComment;

    }


}