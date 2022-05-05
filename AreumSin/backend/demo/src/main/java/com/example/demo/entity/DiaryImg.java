package com.example.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table
public class DiaryImg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DIARY_IMG_NO")
    private Integer diaryImgNo;

    @Column
    private String imgSrc;

    @ManyToOne
    @JoinColumn(name = "DIARY_NO")
    private Diary diary;

    public DiaryImg(String imgSrc, Diary diary) {
        this.imgSrc = imgSrc;
        this.diary = diary;
    }
}
