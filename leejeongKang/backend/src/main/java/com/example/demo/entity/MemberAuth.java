package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "member_auth")
public class MemberAuth {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int memberAuthNo;

    @Column(name = "member_no")
    private int memberNo;

    @Column(length = 64, nullable = false)
    private String auth;

    public MemberAuth(String auth) {
        this.auth = auth;
    }
}
