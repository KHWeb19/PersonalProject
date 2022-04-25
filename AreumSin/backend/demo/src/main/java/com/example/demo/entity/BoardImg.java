package com.example.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table
public class BoardImg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARD_IMG_NO")
    private Integer boardImgNo;

    @Column
    private String imgSrc;

    @ManyToOne
    @JoinColumn(name = "BOARD_NO")
    private Board board;

    public BoardImg(String imgSrc, Board board) {
        this.imgSrc = imgSrc;
        this.board = board;
    }
}
