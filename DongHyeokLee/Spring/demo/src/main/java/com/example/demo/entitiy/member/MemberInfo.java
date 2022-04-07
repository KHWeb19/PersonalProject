package com.example.demo.entitiy.member;

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
public class MemberInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_no")
    private Long memberNo;

    @Column(length = 15, nullable = false)
    private String userId;

    @Column(length = 256, nullable = false)
    private String password;

    @Column(length = 20, nullable = false)
    private String nickname;

    @Column(length = 20, nullable = false)
    private String email;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "member_no")
    private List<MemberAuth> authList;


    public MemberInfo(String userId, String password, String nickname, String email) {
        this.userId = userId;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
    }

    public MemberInfo(String userId, String password, MemberAuth auth) {
        this.userId = userId;
        this.password = password;

        if(auth != null){
            changeAuth(auth);
        }
    }

    public void changeAuth (MemberAuth auth){}

    public void addAuth (MemberAuth auth) {
        if(authList == null) {
            authList = new ArrayList<>();
        }

        authList.add(auth);
    }

    public void clearAuthList() {
        authList.clear();
    }


}
