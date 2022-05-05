package com.example.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    private Integer ref;

    @Column
    private String writer;

    @Column
    private Integer deep; //step

    @Column
    private Integer deepOrder; // 같은 step내에서 순위

    @Column
    private Integer commentNum;

    @Column
    private Integer parent;

    @ManyToOne
    @JoinColumn(name = "BOARD_NO")
    private Board board;

    public BoardComment(String boardComment, Integer ref, String writer, Integer deep, Integer deepOrder, Integer commentNum, Integer parent, Board board) {
        this.boardComment = boardComment;
        this.ref = ref;
        this.writer = writer;
        this.deep = deep;
        this.deepOrder = deepOrder;
        this.commentNum = commentNum;
        this.parent = parent;
        this.board = board;
    }

    public void reply(String boardComment, String writer, Board board, Integer parent, Integer deep){
        this.boardComment = boardComment;
        this.writer = writer;
        this.deep = deep;
        this.parent = parent;
        this.board = board;
    }

}
