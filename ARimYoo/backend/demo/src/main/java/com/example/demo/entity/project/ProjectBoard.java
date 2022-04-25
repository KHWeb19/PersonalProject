package com.example.demo.entity.project;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class ProjectBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectNo;

    @Column (nullable = false)
    private String projectName;

    @Column (nullable = false)
    private String writer;

    @Column (nullable = false)
    private int people;

    @Column (nullable = false)
    private String fileName;

    @Column (nullable = false)
    private String content;

    @Column (nullable = false)
    private String openLink;

    @Column
    private int viewCnt = 0;

    @Formula("(SELECT count(1) FROM project_comment c WHERE c.project_board_project_no = project_no)")
    private int commentCnt;

    public void increaseViewCnt() {
        this.viewCnt++;
    }

}
