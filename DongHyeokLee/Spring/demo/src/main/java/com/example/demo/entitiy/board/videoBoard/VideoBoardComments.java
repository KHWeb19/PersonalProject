package com.example.demo.entitiy.board.videoBoard;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class VideoBoardComments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentNo;

    @Column(name= "board_no")
    private Long boardNo;

    @Column(length = 32, nullable = false)
    private String writer;

    @Column(length = 64, nullable = false)
    private String content;

    @CreatedDate
    @Column(length = 128, nullable = false)
    private String regDate;

    @UpdateTimestamp
    private Date updDate;

    public VideoBoardComments(String writer, String content, Long boardNo){
            this.writer = writer;
            this.content = content;
            this.boardNo = boardNo;
    }

    @PrePersist
    public void onPrePersist(){
        this.regDate = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));
    }


}
