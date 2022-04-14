package com.example.backend.controller.member.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class BoardRequest {

        private Long boardNo;
        private String title;
        private String writer;
        private String content;
        private String fileName;
        private Date regDate;
        private Date updDate;

}
