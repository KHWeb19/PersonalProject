package com.example.demo.entity.jpa;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class VueJpaMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer member_No;

    @Column(length = 32, nullable = false)
    private String id;

    @Column(length = 128, nullable = false)
    private String pw;

    @Column(length = 32, nullable = false)
    private String nickname;

    @Column(length = 32, nullable = false)
    private String email;

    @Column(length = 32, nullable = false)
    private Integer phonenumber;

    @CreationTimestamp
    private Date createdDate;

    @UpdateTimestamp
    private Date lastModifiedDate;

}






