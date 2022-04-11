package com.example.demo.entity.personalProject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNo;

    private String auth;
    private String name;
    private String gender;
    private Date birth;
    private String id;
    private String pw;
    private String address;




}
