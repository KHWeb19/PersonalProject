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
public class BoardComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARD_COMMENT_NO")
    private Integer boardCommentNo;

    @Lob
    private String boardComment;

    @Column
    private String writer;

    @ManyToOne
    @JoinColumn(name = "BOARD_NO")
    private Board board;

    public BoardComment(String boardComment, String writer, Board board) {
        this.boardComment = boardComment;
        this.writer = writer;
        this.board = board;
    }
}
