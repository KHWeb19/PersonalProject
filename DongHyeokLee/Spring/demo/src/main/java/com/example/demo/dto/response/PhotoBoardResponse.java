package com.example.demo.dto.response;


import lombok.*;


import java.util.Date;


@NoArgsConstructor
@Getter
public class PhotoBoardResponse {
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

    public PhotoBoardResponse(String title, String content, String writer, String fileName,
                              Long boardNo, Date regDate, int readCnt, int likeCnt, int likeCheck, int commentCnt){
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
    }

    /*public BoardResponse(VideoBoard board){
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
    }*/




}
