package com.example.demo.entity.project;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class ProjectMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column
    private String member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "project_projectNo")
    @JsonIgnore
    private Project project;

}
