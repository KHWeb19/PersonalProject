package com.example.demo.entity.jpa.Complaint;

import lombok.Data;
import org.hibernate.annotations.Formula;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

@Data
@Entity
public class ComplaintBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNo;

    @Column(length = 128, nullable = false)
    private String title;

    @Column(length = 32, nullable = false)
    private String writer;

    @Lob
    private String content;

    @Column(name = "created_date")
    @CreatedDate
    private String createdDate;

    @Column(name = "modified_date")
    @LastModifiedDate
    private String modifiedDate;

    @Column
    private Integer viewCnt = 0;

    @Formula("(SELECT count(1) FROM complaint_comment c WHERE c.complaint_board_board_no = board_no)")
    private int commentCnt;

    @PrePersist
    public void onPrePersist() {
        this.createdDate = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));
    }

    @PreUpdate
    public void onPreUpdate() {
        this.modifiedDate = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));
    }

    public void increaseViewCnt() {
        this.viewCnt++;
    }

    @OneToMany(mappedBy = "complaintBoard", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<ComplaintComment> comments;
}

