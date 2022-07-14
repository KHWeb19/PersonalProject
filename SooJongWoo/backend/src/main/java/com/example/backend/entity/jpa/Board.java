package com.example.backend.entity.jpa;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name="board")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_no")
    private Long boardNo;

    @Column(length = 200, nullable = false)
    private String title;

    @Column(length = 150, nullable = false)
    private String writer;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    @Builder
    public Board(Long boardNo, String title, String writer, String content ) {
        this.boardNo = boardNo;
        this.title = title;
        this.writer = writer;
        this.content = content;

    }
}
