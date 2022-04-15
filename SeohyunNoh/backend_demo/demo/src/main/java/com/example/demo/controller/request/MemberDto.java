package com.example.demo.controller.request;

import com.example.demo.entity.personalProject.Member;
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
//    private String gender;
    private Date birth;
    private String address;
    private Date regDate;
    private Date updDate;

    public Member toEntity() {
        return Member.builder()
                .id(id)
                .pw(pw)
                .name(name)
     //           .gender(gender)
                .birth(birth)
                .address(address)
                .regDate(regDate)
                .updDate(updDate)
                .build();
    }
}
