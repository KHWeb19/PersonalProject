package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnoreProperties({"member"})
    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
    private Set<Likes> likes = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnoreProperties({"my"})
    @OneToMany(mappedBy = "my", fetch = FetchType.EAGER)
    private Set<Follow> followings = new HashSet<>();

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnoreProperties({"your"})
    @OneToMany(mappedBy = "your", fetch = FetchType.EAGER)
    private Set<Follow> followers = new HashSet<>();

    public Member(String memberName, String memberId, String password, String passwordHint) {
        this.memberName = memberName;
        this.memberId = memberId;
        this.password = password;
        this.passwordHint = passwordHint;
    }
}
