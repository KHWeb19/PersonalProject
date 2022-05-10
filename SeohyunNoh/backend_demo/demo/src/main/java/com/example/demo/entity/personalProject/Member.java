package com.example.demo.entity.personalProject;

import com.example.demo.controller.request.MemberDto;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Builder
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNo;

    private String name;
//    private String gender;
    private Date birth;
    private String id;
    private String pw;
    private String address;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    public void updateMember(MemberDto memberDto) {
        this.pw = memberDto.getPw();
        this.name = memberDto.getName();
        this.birth = memberDto.getBirth();
        this.address = memberDto.getAddress();
    }

}
