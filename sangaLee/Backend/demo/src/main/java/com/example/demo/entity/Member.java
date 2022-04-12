package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Member")
public class Member {

    /* SQL을 이용해서 테이블을 먼저 생성하고, 엔티티 클래스를 만드는 방식
       JPA를 이용해서 클래스만 설계하고 자동으로 테이블을 생성하는 방식 */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNo;

    @Column(length = 20, nullable = false)
    private String userId;

    @Column(length = 15, nullable = false)
    private String password;

    @Column(length = 11, nullable = false)
    private String phonenumber;

    @Column(length = 50, nullable = false)
    private String email;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    public Member(String userId, String password, String phonenumber, String email) {
        this.userId = userId;
        this.password = password;
        this.phonenumber = phonenumber;
        this.email = email;
    }

}
