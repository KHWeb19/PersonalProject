package com.example.demo.entity;

import com.example.demo.request.MemberDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;


@Builder
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "member_no")
    private Long memberNo;

    @Column(length = 50, nullable = false)
    private String id;

    @Column(length = 1000, nullable = false)
    private String pw;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String birth;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(length = 20, nullable = false)
    private String phone;

    @Column(length = 100, nullable = false)
    private String address;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    public void updateMember(MemberDto memberDto) {
        this.pw = memberDto.getPw();
        this.name = memberDto.getName();
        this.birth = memberDto.getBirth();
        this.email = memberDto.getEmail();
        this.phone = memberDto.getPhone();
        this.address = memberDto.getAddress();
    }


}














