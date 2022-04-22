package com.example.demo.controller.Member.request;

import lombok.Data;

@Data
public class MemberCartRequest {
    private Long cartNo;
    private Long boardNo;
    private Long memberNo;
    private String name;
    private String writer;
    private String des;
    private String kind;
    private String mat;
    private String way;
    private String filename;
    private String filepath;

    public MemberCartRequest(Long cartNo, Long memberNo, Long boardNo, String name, String writer, String des, String kind, String mat, String way, String filename, String filepath){
        this.cartNo = cartNo;
        this.memberNo = memberNo;
        this.boardNo = boardNo;
        this.name = name;
        this.writer = writer;
        this.des = des;
        this.kind = kind;
        this.mat = mat;
        this.way = way;
        this.filename = filename;
        this.filepath = filepath;
    }
}
