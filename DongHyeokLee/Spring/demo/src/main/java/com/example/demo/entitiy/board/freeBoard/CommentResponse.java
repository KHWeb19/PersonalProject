package com.example.demo.entitiy.board.freeBoard;

public class CommentResponse {
    private String content;
    private String writer;
    private Long boardNo;

    public CommentResponse(String content, String writer, Long boardNo){
                this.content = content;
                this.writer = writer;
                this.boardNo = boardNo;
    }
}
