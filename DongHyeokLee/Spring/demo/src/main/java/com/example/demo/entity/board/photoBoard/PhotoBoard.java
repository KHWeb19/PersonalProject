package com.example.demo.entity.board.photoBoard;

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

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    @JsonManagedReference
    @OneToMany(mappedBy = "photoBoard", fetch = FetchType.EAGER, orphanRemoval = true)
    private List<PhotoBoardLike> likes = new ArrayList<>();

    public void likeCheckZero(){
        likeCheck--;
    }

}
