package com.example.demo.entity;

import com.sun.istack.NotNull;
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
    private Long memberNo;

    @Column(length = 64, nullable = false)
    private String id;

    @Column(length = 64, nullable = false)
    private String pw;

    @Column(length = 50, nullable = false)
    private String email;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    public Member (Long memberNo, String userId, String password, String userEmail) {
        this.memberNo = memberNo;
        this.id = userId;
        this.pw = password;
        this.email = userEmail;
    }
}
