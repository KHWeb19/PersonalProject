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
    private Integer memberNo;

    @Column(length = 12, nullable = false)
    private String id;

    @Column(nullable = false)
    private String pw;

    @Column(length = 7, nullable = false)
    private String name;

    @Column(nullable = false)
    private String birth;

    @CreationTimestamp
    private Date createdDate;

    @UpdateTimestamp
    private Date lastModifiedDate;

    public Member (String userId, String password) {
        this.id = userId;
        this.pw = password;
    }
}
