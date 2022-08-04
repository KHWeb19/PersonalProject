package com.example.demo.entity.Member;

import com.example.demo.entity.Appointment.Appointment;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@NoArgsConstructor
@Table (name = "member")
public class Member {
    @Id //엔티티 식별 = primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNo;

    @Column(length = 20, nullable = false)
    private String id;

    @Column(length = 100 , nullable = false)
    private String password;

    @Column(length = 10, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String birth;

    @Column(length = 20, nullable = false)
    private String phone;

    public Member(String id, String password, String name, String birth, String phone) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.birth = birth;
        this.phone = phone;
    }

    public Member(Long memberNo) {
        this.memberNo = memberNo;
        this.id = id;
        this.password = password;
        this.name = name;
        this.birth = birth;
        this.phone = phone;
    }

}
