package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
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

    @Column(length = 32, nullable = false)
    private String userId;

    @Column(length = 64, nullable = false)
    private String password;

    @Column(length = 64, nullable = false)
    private String passwordCheck;

    @Column(length = 64, nullable = false)
    private String email;

    @Column(length = 64)
    private String auth;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    @Fetch(value = FetchMode.SUBSELECT)// 이것을 해야 Json 오류가 안생김
    @JsonManagedReference
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
    private List<MemberAuth> authList = new ArrayList();

    @Fetch(value = FetchMode.SUBSELECT)
    //@JsonManagedReference
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
    private List<Reservation> reservation = new ArrayList<>();

    public Member (String userId, String password, String passwordCheck, String email) {
        this.userId = userId;
        this.password = password;
        this.passwordCheck = passwordCheck;
        this.email = email;
    }

    public Member (String userId, String password, String passwordCheck, String email, MemberAuth auth) {
        this.userId = userId;
        this.password = password;
        this.passwordCheck = passwordCheck;
        this.email = email;

        if (auth != null) {
            changeAuth(auth);
        }
    }

    public void changeAuth (MemberAuth auth) {}

    public Member (String userId, String password, String passwordCheck, String email, MemberAuth auth,Reservation rsv) {
        this.userId = userId;
        this.password = password;
        this.passwordCheck = passwordCheck;
        this.email = email;

    }

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



