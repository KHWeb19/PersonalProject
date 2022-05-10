package com.example.demo.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
public class ReplyRequest {

    private String reply;
    private String writer;
    private Long commentNo;
    private Date regDate;

    public ReplyRequest(String reply, String writer, Long commentNo, Date regDate){
        this.reply = reply;
        this.writer = writer;
        this.commentNo = commentNo;
        this.regDate = regDate;
    }

}
