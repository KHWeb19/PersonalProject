package com.example.demo.entity.study;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Study {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studyNo;

    @Column
    private String studyName;

    @Column
    private String firstMember;

    @Column
    private int people;

    @Column
    private String fileName;

    @Column
    private String content;

    @Column
    private String openLink;

    @Column
    private String toDo;

    @Column
    private int viewCnt = 0;

}
