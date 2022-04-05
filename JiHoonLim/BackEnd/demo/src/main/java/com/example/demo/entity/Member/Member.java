package com.example.demo.entity.Member;

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
    @Column(name = "member_no")
    private Long memberNo;

    @Column(length = 64,nullable = false)
    private String id;

    @Column(length = 64,nullable = false)
    private String pw;

    @Column(length = 64,nullable = false)
    private String name;

    @Column(length = 64,nullable = false)
    private String nickName;

    @Column(length = 64,nullable = false)
    private String email;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "member_no")
    private List<MemberAuth> authList;

    public Member(String id, String pw, String name ,String nickName, String email){
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.nickName = nickName;
        this.email = email;
    }

    public void addAuth(MemberAuth auth){
        if (authList == null){
            authList = new ArrayList<MemberAuth>();
        }
        authList.add(auth);
    }

    public void clearAuthList(){
        authList.clear();
    }

}
