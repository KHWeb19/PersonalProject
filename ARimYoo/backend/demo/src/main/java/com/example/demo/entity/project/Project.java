package com.example.demo.entity.project;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectNo;

    @Column
    private String projectName;

    @Column
    private String firstMember;

    @Column
    private int people;

    @Column
    private String fileName;

    @Column
    private String openLink;

    @Column
    private String toDo;

    public Project(String projectName, String firstMember, int people, Long projectNo, String fileName, String openLink) {
        this.projectNo = projectNo;
        this.projectName = projectName;
        this.firstMember = firstMember;
        this.people = people;
        this.fileName = fileName;
        this.openLink = openLink;
    }

}
