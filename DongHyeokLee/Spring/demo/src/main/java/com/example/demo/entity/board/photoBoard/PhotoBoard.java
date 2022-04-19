package com.example.demo.entity.board.photoBoard;

import com.example.demo.entity.board.freeBoard.FreeBoardComments;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhotoBoard  {

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

    @Formula("(Select count(1) From photo_board_like c Where c.board_No = board_No)")
    private int likeCnt;

    @Formula("(Select count(1) From photo_board_comments c Where c.board_No = board_No)")
    private int commentCnt;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;


    @JsonManagedReference
    @OneToMany(mappedBy = "photoBoard", fetch = FetchType.LAZY,  cascade = CascadeType.ALL)
    private List<PhotoBoardLike> likes = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "photoBoard", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PhotoBoardComments> comments = new ArrayList<>();

    public void likeCheckZero(){
        likeCheck = 0;
    }

    public void readCnt() {
        this.readCnt++;
    }

}
