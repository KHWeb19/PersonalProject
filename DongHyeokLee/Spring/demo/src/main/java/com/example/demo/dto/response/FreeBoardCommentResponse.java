package com.example.demo.dto.response;

import com.example.demo.entity.board.freeBoard.FreeBoardComments;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
public class FreeBoardCommentResponse {
    private String writer;
    private String comment;
    private Long boardNo;
    private Date regDate;
    private Long commentNo;
    private FreeBoardComments freeBoardComments;


    public FreeBoardCommentResponse(String writer, String comment, Long boardNo, Date regDate, Long commentNo, FreeBoardComments freeBoardComments){
        this.writer = writer;
        this.comment = comment;
        this.boardNo = boardNo;
        this.regDate = regDate;
        this.commentNo = commentNo;
        this.freeBoardComments = freeBoardComments;

    }
}
