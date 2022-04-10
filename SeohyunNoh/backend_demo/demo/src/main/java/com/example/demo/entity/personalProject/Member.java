package com.example.demo.entity.personalProject;

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
    @Column(name = "member_no")
    private Long memberNo;

    @Column(length = 32, nullable = false)
    private String auth;

    @Column(length = 32, nullable = false)
    private String id;

    @Column(length = 128, nullable = false)
    private String pw;

    @Column(length = 128, nullable = false)
    private String name;

    @Column(length = 10, nullable = false)
    private String gender;

    @Column(length = 300, nullable = false)
    private String address;

    @Column(length = 128, nullable = false)
    private Date birthDay;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    public Member (String auth, String id, String pw, String name, String gender, String address, Date birthDay) {
        this.auth = auth;
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.birthDay = birthDay;
    }
}
