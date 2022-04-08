package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table (name = "member")
public class Member {
    @Id //엔티티 식별 = primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "member_no")
    private int member_no;

    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name" , nullable = false)
    private String name;

    @Column(name = "birth", nullable = false)
    private String birth;

    @Column(name = "phone", nullable = false)
    private String phone;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "member_no")
    private List<MemberAuth> authList;

    public Member(String id, String password, String name, String birth, String phone) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.birth = birth;
        this.phone = phone;
    }

    public void addAuth (MemberAuth auth) {
        if (authList == null) {
            authList = new ArrayList<MemberAuth>();
        }
        authList.add(auth);
    }

    public void clearAuthList () {
        authList.clear();
    }
}
