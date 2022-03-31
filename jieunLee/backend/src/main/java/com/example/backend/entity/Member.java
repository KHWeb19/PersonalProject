package com.example.backend.entity;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberNo;

    @Column(length = 32, nullable = false)
    private String memberName;

    @Column(length = 32, nullable = false)
    private String memberId;

    @Column(length = 64, nullable = false)
    private String password;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberAuth> authList = new ArrayList();

    public Member (String memberName, String memberId, String password) {
        this.memberName = memberName;
        this.memberId = memberId;
        this.password = password;
    }

    public Member (String memberName, String memberId, String password, MemberAuth auth) {
        this.memberName = memberName;
        this.memberId = memberId;
        this.password = password;

        if (auth != null) {
            changeAuth(auth);
        }
    }

    public void changeAuth(MemberAuth auth) {

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
