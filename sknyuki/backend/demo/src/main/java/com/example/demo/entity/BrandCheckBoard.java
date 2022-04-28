package com.example.demo.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class BrandCheckBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNo;

    @Column(length = 60, nullable = false)
    private String type;

    @Column(length = 60, nullable = false)
    private String id;

    @Column(length = 128, nullable = false)
    private String title;

    @Column(length = 32, nullable = false)
    private String writer;

    @Lob
    private String content;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;
}
