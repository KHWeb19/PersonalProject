package com.example.backend.controller.serviceBoard;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class CenterCommentRequest {

    private Long centerNo;
    private String commentWriter;
    private String comment;
    private Date regDate;

    public CenterCommentRequest( Long centerNo,String commentWriter, String comment, Date regDate) {
        this.centerNo = centerNo;
        this.commentWriter = commentWriter;
        this.comment = comment;
        this.regDate = regDate;

    }
}
