package com.example.demo.controller.Member.request;

import lombok.Data;

@Data
public class MemberCartRequest {
    private Long boardNo;
    private Long memberNo;
    private String name;
    private String writer;
    private String material;
    private String des;
    private String tip;
    private String kind;
    private String mat;
    private String way;
    private String content;
    private String filename;
    private String filepath;
    private Integer viewCount;


}
