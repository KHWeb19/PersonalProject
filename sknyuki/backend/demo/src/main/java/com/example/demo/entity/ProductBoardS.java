package com.example.demo.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class ProductBoardS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNo;

    @Column(length = 60, nullable = false)
    private String type;

    @Column(length = 60, nullable = false)
    private String id;

    @Column(length = 128, nullable = false)
    private String name;

    @Column(length = 32, nullable = false)
    private String size;

    @Column(length = 32, nullable = false)
    private int price;

    @Column(length = 32, nullable = false)
    private String accessories;

    @Column(length = 32, nullable = false)
    private String brandrank;

    @Column(length = 32, nullable = false)
    private boolean soldCheck;

    @Lob
    private String status;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;
}
