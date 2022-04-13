package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNo;

    @Column(length = 20, nullable = false)
    private String userId;

    @Column(length = 15, nullable = false)
    private String password;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberAuth> authList = new ArrayList<>();

    public Member (String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public Member (String userId, String password, MemberAuth auth) {
        this.userId = userId;
        this.password = password;

        if(auth != null) {
            changeAuth(auth);
        }
    }

    public void changeAuth(MemberAuth auth) {}

    public void addAuth (MemberAuth auth) {
        if (authList == null) {
            authList = new ArrayList();
        }

        authList.add(auth);
    }

    public void clearAuthList () {
        authList.clear();
    }
}
