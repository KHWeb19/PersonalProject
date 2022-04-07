package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
//@Table에 name을 추가하면 테이블 이름이 name값으로 설정되어야 한다.
public class Member {
    @Id //특정 속성을 기본키로 설정하는 어노테이션
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNo;

    @Column(length = 32, nullable = false)
    private String userId;

    @Column(length = 32, nullable = false)
    private String storeName;

    @Column(length = 128, nullable = false)
    private String password;

    @Column(length = 128, nullable = false)
    private String passwordQAnswer;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;


    public Member(String userId, String storeName, String password, String passwordQAnswer) {
        this.userId = userId;
        this.storeName = storeName;
        this.password = password;
        this.passwordQAnswer = passwordQAnswer;
    }
}
