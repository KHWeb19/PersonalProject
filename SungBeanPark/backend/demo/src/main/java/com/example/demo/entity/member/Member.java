package com.example.demo.entity.member;

import com.example.demo.entity.Cart.Cart;
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

    @Column(length = 32)
    private String id;

    @Column(length = 64)
    private String password;

    @Column(length = 64)
    private String userName;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name ="member_no")
    private List<MemberAuth> authList = new ArrayList<>();


    public Member (String id, String password, String userName) {
        this.id = id;
        this.password = password;
        this.userName = userName;
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
