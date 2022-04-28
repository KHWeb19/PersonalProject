package com.example.demo.entity.study;

import com.example.demo.entity.communityBoard.CommunityCommentBox;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class StudyBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studyNo;

    @Column (nullable = false)
    private String studyName;

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

    @Formula("(SELECT count(1) FROM study_comment c WHERE c.study_board_study_no = study_no)")
    private int commentCnt;

    @Column
    private int viewCnt = 0;

    public void increaseViewCnt() {
        this.viewCnt++;
    }

}
