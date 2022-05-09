package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Data
@Entity
@NoArgsConstructor
//밑에두개는 같이 써줘야함
@AllArgsConstructor
@Builder
public class Comment {

    @Id
    @Column(name = "comment_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentNo;

    @Lob
    private String content;

    @CreatedDate
    private String regDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));

    @UpdateTimestamp
    private Date updDate;

    @JsonBackReference(value="board-comment")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "board_no")
    private Board board;

    @JsonIgnoreProperties({"boards", "comments", "likes"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "member_no")
    private Member member;

}
