package com.example.demo.entity.uploadCake;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    @Column(length = 128, nullable = false)
    private String linkInfo;

    @CreationTimestamp
    private Date regDate;



    public UploadCake(String design, String size, String price, String linkInfo){
        this.design = design;
        this.size = size;
        this.price = price;
        this.linkInfo = linkInfo;
    }

}
