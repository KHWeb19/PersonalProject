package com.example.demo.entity.personalProject;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memberNo;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String gender;

    @Column(length = 20, nullable = false)
    private Date birthDay;

    @Column(length = 20, nullable = false)
    private String id;

    @Column(length = 20, nullable = false)
    private String pw;

    @Column(length = 100, nullable = false)
    private String address;

    @CreationTimestamp
    private Date createdDate;

    @UpdateTimestamp
    private Date lastModifiedDate;
}
