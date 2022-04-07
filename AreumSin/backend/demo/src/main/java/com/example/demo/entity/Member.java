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
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_NO")
    private Integer memberNo;

    @Column(name = "USER_ID", nullable = false)
    private String id;

    @Column(name = "USER_PW", nullable = false)
    private String pw;

    @Column(name = "USER_NAME")
    private String name;

    @Column(name = "USER_BIRTH")
    private Integer birth;

    @Column(name = "USER_COLOR")
    private String color;

    @Column(name = "USER_SESSION_KEY")
    private String sessionKey;
/*
    @CreationTimestamp
    @Column(name = "USER_SESSION_LIMIT")
    private Date session_limit;*/

    @CreationTimestamp
    private Date createdDate;

    @UpdateTimestamp
    private Date userLoginDate;

    public MemberPlan(String member) {
        this.member = member
    }
}
