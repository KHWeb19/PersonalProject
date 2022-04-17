package com.example.demo.entity.board.photoBoard;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@NoArgsConstructor
public class PhotoBoardComments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentNo;

    @Column(name= "board_no")
    private Long boardNo;

    @Column(length = 32, nullable = false)
    private String writer;

    @Column(length = 64, nullable = false)
    private String comment;

    @CreatedDate
    @Column(length = 128, nullable = false)
    private String regDate;

    @UpdateTimestamp
    private Date updDate;

    public PhotoBoardComments(String writer, String comment, Long boardNo){
        this.writer = writer;
        this.comment = comment;
        this.boardNo = boardNo;
    }

}
