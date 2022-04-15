package com.example.demo.entity.FoodBoard;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class FoodBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNo;

    @Column(length = 128, nullable = false)
    private String name;

    @Column(length = 32, nullable = false)
    private String writer;

    @Column(nullable = false)
    private String material;

    @Column(nullable = false)
    private String des;

    @Column
    private String tip;

    @Column(nullable = false)
    private String kind;

    @Column(nullable = false)
    private String mat;

    @Column(nullable = false)
    private String way;

    @Lob
    private String content;

    @Column
    private String filename;

    @Column
    private String filepath;

    @Column()
    private Integer viewCount = 0;


    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;


}
