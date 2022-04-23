package com.example.demo.request;


import com.example.demo.entity.user.Member;
import lombok.*;

import java.util.Date;
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
    private String id;
    private String pw;
    private String name;

    private Date regDate;
    private Date updDate;

    public Member toEntity() {
        return Member.builder()
                .id(id)
                .pw(pw)

                .regDate(regDate)
                .updDate(updDate)
                .build();
    }
}
