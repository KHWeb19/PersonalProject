package com.example.demo.entity.member;

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

    @Column(length = 64, nullable = false)
    private String userId;

    @Column(length = 64, nullable = false)
    private String password;

    @Column(length = 64, nullable = false)
    private String userName;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberAuth> authList = new ArrayList<>();

    public Member (String userId, String password, String userName) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;
    }

    public Member (String userId, String password, String userName, MemberAuth auth) {
        this.userId = userId;
        this.password = password;
        this.userName = userName;

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
