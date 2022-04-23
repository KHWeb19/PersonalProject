package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Transactional
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_NO")
    private Integer memberNo;

    @Column(name = "USER_ID", nullable = false)
    private String id;

    @Column(name = "USER_PW", nullable = false)
    private String pw;

    @Column(name = "USER_NAME")
    private String name;

    @Column(name = "USER_BIRTH")
    private Integer birth;

    @Column(name = "USER_COLOR")
    private String color;

    @Column(name = "USER_SESSION_KEY")
    private String sessionKey;
/*
    @CreationTimestamp
    @Column(name = "USER_SESSION_LIMIT")
    private Date session_limit;*/

    @CreationTimestamp
    private Date createdDate;

    @UpdateTimestamp
    private Date userLoginDate;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<MemberPlan> memberPlans = new ArrayList<>();

    public void addMemberPlan(MemberPlan memberPlan){
        memberPlans.add(memberPlan);
        memberPlan.setMember(this);
    }

    public static Member inviteMember(Member member, MemberPlan... memberPlans) {

        for(MemberPlan memberPlan : memberPlans) {
            member.addMemberPlan(memberPlan);
        }
        return member;
    }

}
