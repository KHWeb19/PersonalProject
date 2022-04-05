package com.example.demo.entity.uploadCake;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class UploadCake {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cakeNo;

    @Column(length = 32, nullable = false)
    private String design;

    @Column(length = 32, nullable = false)
    private String size;

    @Column(length = 32, nullable = false)
    private String price;

    @CreationTimestamp
    private Date regDate;

    public UploadCake(String design, String size, String price){
        this.design = design;
        this.size = size;
        this.price = price;
    }
}
