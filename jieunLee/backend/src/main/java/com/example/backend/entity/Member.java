package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_No")
    private Long memberNo;

    @Column(length = 32)
    private String memberName;

    @Column(length = 32, nullable = false)
    private String memberId;

    @Column(length = 64)
    private String password;

    @Column(length = 32, nullable = false)
    private String passwordHint;

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

    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
    private List<Board> boards = new ArrayList<>();

    //이거는 필요없긴함 없애보자
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @JsonIgnoreProperties({"member"})
//    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
//    private Set<Comment> memberComments = new HashSet<>();

    public Member(String memberName, String memberId, String password, String passwordHint) {
        this.memberName = memberName;
        this.memberId = memberId;
        this.password = password;
        this.passwordHint = passwordHint;
    }
}
