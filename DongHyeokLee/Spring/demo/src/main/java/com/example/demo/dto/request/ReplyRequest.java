package com.example.demo.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
public class ReplyRequest {

    private String reply;
    private String writer;
    private Long parCommentNo;
    private Date regDate;

    public ReplyRequest(String reply, String writer, Long parCommentNo, Date regDate){
        this.reply = reply;
        this.writer = writer;
        this.parCommentNo = parCommentNo;
        this.regDate = regDate;
    }

}
