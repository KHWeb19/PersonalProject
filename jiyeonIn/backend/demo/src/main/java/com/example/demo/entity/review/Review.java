package com.example.demo.entity.review;

import com.example.demo.entity.member.Member;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Data
@Entity
@NoArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewNo;

    @Column(length = 32, nullable = false)
    private String id;

    @Column(length = 128, nullable = false)
    private String content;

    @Column(length = 128, nullable = true)
    private String reviewFile;

    @CreatedDate
    @Column(length = 128, nullable = true)
    private String regDate;

    @PrePersist
    public void onPrePersist(){
        this.regDate = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
    }

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "member_no")
    private Member memberReview;

    public Review(String id, String content, String file) {
        this.id = id;
        this.content = content;
        this.reviewFile = file;
    }

    public Review(String id, String content, String file, Member member) {
        this.id = id;
        this.content = content;
        this.reviewFile = file;
        memberReview = member;
    }

    public Review(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public Review(String id, String content, Member member) {
        this.id = id;
        this.content = content;
        memberReview = member;
    }
}
