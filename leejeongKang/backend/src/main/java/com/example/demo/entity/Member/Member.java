package com.example.demo.entity.Member;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table (name = "member")
public class Member {
    @Id //엔티티 식별 = primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNo;

    @Column(length = 20, nullable = false)
    private String id;

    @Column(length = 100 , nullable = false)
    private String password;

    @Column(length = 10, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String birth;

    @Column(length = 20, nullable = false)
    private String phone;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberAuth> authList = new ArrayList<>();

    public Member(String id, String password, String name, String birth, String phone) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.birth = birth;
        this.phone = phone;
    }

    public Member(Long memberNo, String id, String password, String name, String birth, String phone) {
        this.memberNo = memberNo;
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
