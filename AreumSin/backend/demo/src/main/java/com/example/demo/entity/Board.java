package com.example.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Arrays;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARD_NO")
    private Integer boardNo;

    @Column
    private String title;

    @Column
    private String place;

    @Column
    private String writer;

    @Lob
    private String boardContent;

    @Column
    private String imgSrc;

    public Board(String title, String place, String writer, String boardContent, String imgSrc) {
        this.place = place;
        this.title = title;
        this.writer = writer;
        this.boardContent = boardContent;
        this.imgSrc = imgSrc;
    }

}
