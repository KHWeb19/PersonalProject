package com.example.demo.entity.user;

import com.example.demo.request.MemberDto;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "member_no")
    private Long memberNo;

    @Column(length = 50, nullable = false)
    private String id;

    @Column(length = 150, nullable = false)
    private String pw;

    @Column(length = 20)
    private String name;



    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;


    public void updateMember(MemberDto memberDto) {
        this.pw = memberDto.getPw();
        this.name = memberDto.getName();

    }

}














