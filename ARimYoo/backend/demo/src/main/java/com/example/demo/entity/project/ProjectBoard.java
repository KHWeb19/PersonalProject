package com.example.demo.entity.project;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class ProjectBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectNo;

    @Column
    private String projectName;

    @Column
    private String writer;

    @Column
    private int people;

    @Column
    private String fileName;

    @Column
    private String content;

    @Column
    private String openLink;

    @Column
    private int viewCnt = 0;

    public void increaseViewCnt() {
        this.viewCnt++;
    }

}
