package com.example.demo.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class StoreBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNo;

    @Column(length = 32, nullable = false)
    private String city;

    @Column(length = 32, nullable = false)
    private String gu;

    @Column(length = 32, nullable = false)
    private String dong;

    @Column(length = 128, nullable = false)
    private String address;

    //이게 Member에 등록된 storeName이 되어야 함
    @Column(length = 32, nullable = false)
    private String storeName;

    @Lob
    //@Lob은 일반적인 데이터베이스에서 저장하는 길이인 255개 이상의 문자를 저장하고 싶을 때 지정한다.
    private String content;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;
}
