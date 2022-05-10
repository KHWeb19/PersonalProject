package com.example.demo.entity.board.freeBoard;


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
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FreeBoard {

    @Id
    @Column(name="board_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNo;

    @Column(length = 18, nullable = false)
    private String title;

    @Column(length = 18, nullable = false)
    private String writer;

    @Formula("(Select count(1) From free_board_comments c Where c.board_No = board_No)")
    private int commentCnt;

    @Lob
    private String content;

    @Column(columnDefinition = "integer default 0")
    private int count;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    @JsonIgnore
    @OneToMany(mappedBy = "freeBoard", fetch = FetchType.EAGER, orphanRemoval = true)
    private List<FreeBoardComments> comments = new ArrayList<>();

   /* public FreeBoard (String title, String writer, String content) {
        this.title = title;
        this.writer = writer;
        this.content = content;
    }

    public void setFreeBoardComments (FreeBoardComments freeBoardComments){
        comments.add(freeBoardComments);
        //이거해야 boardNo들어옴
        freeBoardComments.setFreeBoard(this);
    }*/





}
