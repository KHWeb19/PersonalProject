package com.example.demo.entity.study;

import com.example.demo.entity.review.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class StudyMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @Column
    private String member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "study_studyNo")
    @JsonIgnore
    private Study study;

}
