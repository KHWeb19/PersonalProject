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
@Table(name = "cake_member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNo;

    @Column(length = 32, nullable = false)
    private String userId;

    @Column(length = 128, nullable = false)
    private String password;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    @OneToMany(mappedBy = "cake_member", cascade = CascadeType.ALL)
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
}
