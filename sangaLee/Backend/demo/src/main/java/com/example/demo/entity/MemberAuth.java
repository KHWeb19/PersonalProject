package com.example.demo.entity;

import com.example.demo.entity.Member;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "member_auth")
public class MemberAuth<z> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberAuthNo;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "member_no")
    @JsonIgnore
    private Member member;

    @Column(length = 64, nullable = false)
    private String auth;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    public MemberAuth(String auth, Member memberTable) {
        this.auth = auth;
        member = memberTable;
    }
}
