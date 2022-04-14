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

    @Column(length = 64)
    private String password;

    @Column(length = 64)
    private String imageName;

    @Column(length = 128)
    private String memberWeb;

    @Lob
    private String memberIntro;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    //
//    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "member_no")
//    private List<Board> boardList;

    public Member(String memberName, String memberId, String password) {
        this.memberName = memberName;
        this.memberId = memberId;
        this.password = password;
    }
}
