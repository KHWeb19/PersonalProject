package com.example.demo.dto;


import com.example.demo.entity.board.photoBoard.PhotoBoard;
import lombok.Getter;

import java.util.Date;

@Getter
public class BoardResponse {
    private String title;
    private String content;
    private String writer;
    private String fileName;
    private Long boardNo;
    private Date regDate;
    private int readCnt;
    private int likeCheck;
    private int likeCnt;
    private int commentCnt;

   /* public BoardResponse(String title, String content, String writer, String fileName,
                         Long boardNo, Date regDate, int readCnt, int likeCheck, int likeCnt, int commentCnt) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.fileName = fileName;
        this.boardNo = boardNo;
        this.regDate = regDate;
        this.readCnt = readCnt;
        this.likeCheck = likeCheck;
        this.likeCnt = likeCnt;
        this.commentCnt = commentCnt;
    }*/

    public BoardResponse(PhotoBoard board){
        this.title = board.getTitle();
        this.content = board.getContent();
        this.writer = board.getWriter();
        this.fileName = board.getFileName();
        this.boardNo = board.getBoardNo();
        this.regDate = board.getRegDate();
        this.readCnt = board.getReadCnt();
        this.likeCheck = board.getLikeCheck();
        this.likeCnt = board.getLikeCnt();
        this.commentCnt = board.getCommentCnt();
    }




}
