package com.example.demo.request;

import com.example.demo.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
    private String id;
    private String pw;
    private String name;
    private String birth;
    private String email;
    private String phone;
    private String address;
    private Date regDate;
    private Date updDate;

    public Member toEntity() {
        return Member.builder()
                .id(id)
                .pw(pw)
                .name(name)
                .birth(birth)
                .email(email)
                .phone(phone)
                .address(address)
                .regDate(regDate)
                .updDate(updDate)
                .build();
    }
}
