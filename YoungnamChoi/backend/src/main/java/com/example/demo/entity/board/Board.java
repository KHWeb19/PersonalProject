package com.example.demo.entity.board;


import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNo;

    @Column(length = 128, nullable = false)
    private String title;



    @Lob
    private String content;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;
}
