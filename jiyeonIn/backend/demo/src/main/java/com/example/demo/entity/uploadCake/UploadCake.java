package com.example.demo.entity.uploadCake;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor

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

    public UploadCake(Long cakeNo, String design, String size, String price, String linkInfo){
        this.cakeNo = cakeNo;
        this.design = design;
        this.size = size;
        this.price = price;
        this.linkInfo = linkInfo;
    }

}
