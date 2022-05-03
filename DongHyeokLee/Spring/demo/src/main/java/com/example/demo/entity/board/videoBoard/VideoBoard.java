package com.example.demo.entity.board.videoBoard;

import com.example.demo.entity.board.photoBoard.PhotoBoardComments;
import com.example.demo.entity.board.photoBoard.PhotoBoardLike;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VideoBoard {

    @Id
    @Column(name="board_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNo;

    @Column(length = 18, nullable = false)
    private String title;

    @Column(length = 18, nullable = false)
    private String writer;

    @Column
    private String fileName;

    @Lob
    private String content;

    @Column
    private int readCnt;

    @Column
    private int likeCheck;

    @Formula("(Select count(1) From video_board_like c Where c.board_No = board_No)")
    private int likeCnt;

    @Formula("(Select count(1) From video_board_comments c Where c.board_No = board_No)")
    private int commentCnt;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;


    @JsonIgnore
    @OneToMany(mappedBy = "videoBoard", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
    private List<VideoBoardLike> likes = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "videoBoard", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<VideoBoardComments> comments = new ArrayList<>();

    public void likeCheckZero(){
        likeCheck = 0;
    }

    public void readCnt() {
        this.readCnt++;
    }


}
