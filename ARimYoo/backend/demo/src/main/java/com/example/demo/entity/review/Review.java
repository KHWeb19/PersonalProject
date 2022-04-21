package com.example.demo.entity.review;

import com.example.demo.entity.communityBoard.CommunityBoardLike;
import com.example.demo.entity.communityBoard.CommunityCommentBox;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewNo;

    @Column(length = 128, nullable = false)
    private String title;

    @Column (nullable = false)
    private String writer;

    @Lob
    private String content;

    @Column (nullable = false)
    private String brackets;

    @Column
    private String fileName1;

    @Column
    private String fileName2;

    @Column
    private String fileName3;

    @Column
    private String fileName4;

    @Column
    private String fileName5;

    @Column
    private int viewCnt = 0;

    @Formula("(SELECT count(1) FROM review_comment r WHERE r.review_review_no = review_no)")
    private int commentCnt;

    @Formula("(SELECT count(1) FROM review_like r WHERE r.review_review_no = review_no)")
    private int likeCnt;

    @CreatedDate
    private String regDate = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));

    @UpdateTimestamp
    private LocalDateTime upDate;

    @OneToMany(mappedBy = "review", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<ReviewComment> comment;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "review", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<ReviewLike> likes = new HashSet<>();

    public void increaseViewCnt() {
        this.viewCnt++;
    }

    public Review (String fileName1, String fileName2){
        this.fileName1 = fileName1;
        this.fileName2 = fileName2;
    }
}
