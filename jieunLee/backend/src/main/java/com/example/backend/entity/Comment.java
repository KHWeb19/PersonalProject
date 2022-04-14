package com.example.backend.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Comment {

    @Id
    @Column(name = "comment_no")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long commentNo;

}
