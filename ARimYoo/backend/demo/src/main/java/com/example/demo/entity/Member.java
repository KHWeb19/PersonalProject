package com.example.demo.entity;

import com.example.demo.entity.project.Project;
import com.example.demo.entity.study.Study;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.*;

@Data
@Entity
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNo;

    @NotNull
    @Column(length = 12)
    private String id;

    @NotNull
    @Column
    private String pw;

    @NotNull
    @Column(length = 7)
    private String name;

    @NotNull
    @Column
    private String birth;

    @Column(length = 500)
    private String intro;

    @Column
    private String profilePic;

    @CreationTimestamp
    private Date createdDate;

    @UpdateTimestamp
    private Date lastModifiedDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Study> study = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Project> project = new ArrayList<>();

    // 스터디 추가
    public void addStudy(Study study) {
        this.study.add(study);
    }

    public void addProject(Project project) {this.project.add(project);}

    public Member (Long memberNo, String userId, String password, String userName, String userBirth,
                   String userIntro, String userProfilePic) {
        this.memberNo = memberNo;
        this.id = userId;
        this.pw = password;
        this.name = userName;
        this.birth = userBirth;
        this.intro = userIntro;
        this.profilePic = userProfilePic;

    }
}
