package com.example.demo.entitiy.board.freeBoard;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
public class FreeBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNo;

    @Column(length = 18, nullable = false)
    private String title;

    @Column(length = 18, nullable = false)
    private String writer;

    @Lob
    private String content;

    @Column
    private int count;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;





}
