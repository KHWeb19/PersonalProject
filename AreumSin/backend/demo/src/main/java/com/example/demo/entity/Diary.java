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
public class Diary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DIARY_NO")
    private Integer DiaryNo;

    @Column
    private String planName;

    @Column
    private String title;

    @Lob
    private String content;

    @Column
    private String diarySrc;

    @ManyToOne
    @JoinColumn(name = "USER_NO")
    private Member member;

    public Diary(String planName, String title, String content, String diarySrc, Member member) {
        this.planName = planName;
        this.title = title;
        this.content = content;
        this.diarySrc = diarySrc;
        this.member = member;
    }
}
