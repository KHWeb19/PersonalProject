package com.example.demo.entity.member;


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
@Table(name="member_auth")
public class MemberAuth {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberAuthNo;

    @Column(name = "member_no")
    private Long member;

    @Column(length = 64, nullable = false)
    private String auth;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;


    public MemberAuth(String auth){
        this.auth = auth;
    }
}

