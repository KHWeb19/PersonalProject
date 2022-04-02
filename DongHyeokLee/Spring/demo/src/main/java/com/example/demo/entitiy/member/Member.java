package com.example.demo.entitiy.member;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "memberBoth")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNo;

    @Column(length = 15, nullable = false)
    private String userId;

    @Column(length = 256, nullable = false)
    @JsonIgnore
    private String password;

    @Column(length = 20, nullable = false)
    private String nickname;

    @Column(length = 20, nullable = false)
    private String email;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    //mappedBy ="member" 헀더니 생성이 안되서 tabled이랑 이름변경함

    @OneToMany(mappedBy = "memberBoth", cascade = CascadeType.ALL)
    private List<MemberAuth> authList = new ArrayList<>();

    public Member(String userId, String password, String nickname, String email) {
        this.userId = userId;
        this.password = password;
        this.nickname = nickname;
        this.email = email;
    }

    public Member(String userId, String password, MemberAuth auth) {
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
