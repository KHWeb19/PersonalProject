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
@Table(name="member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNo;

    @Column(length = 12, nullable = false)
    private String id;

    @Column(nullable = false)
    private String pw;

    @Column(length = 7, nullable = false)
    private String name;

    @Column(nullable = false)
    private String birth;

    @Column(length = 500)
    private String intro;

    @Column
    private String profilePic;

    @CreationTimestamp
    private Date createdDate;

    @UpdateTimestamp
    private Date lastModifiedDate;

    public Member (String userId, String password, String name, String birth, String intro, String profilePic) {
        this.id = userId;
        this.pw = password;
        this.name = name;
        this.birth = birth;
        this.intro = intro;
        this.profilePic = profilePic;
    }
}
