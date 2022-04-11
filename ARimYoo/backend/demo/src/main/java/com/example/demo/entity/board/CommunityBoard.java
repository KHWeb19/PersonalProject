package com.example.demo.entity.board;

import com.example.demo.entity.Member;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class CommunityBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNo;

    @Column(length = 128, nullable = false)
    private String title;

    @Column (nullable = false)
    private String writer;

    @Lob
    private String content;

    @Column (nullable = false)
    private String brackets;

    @Column
    private String fileName;
    @Column
    private String filePath;

    @Column
    private int viewCnt = 0;

    @CreatedDate
    private String regDate = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));

//

    @UpdateTimestamp
    private LocalDateTime upDate;


    public void increaseViewCnt() {
        this.viewCnt++;
    }

    public CommunityBoard (String fileName){
        this.fileName = fileName;
    }
//    public CommunityBoard (Long boardNo, String title, String writer, String content, String brackets,
//                   String viewCnt) {
//        this.boardNo = boardNo;
//        this.title = title;
//        this.writer = writer;
//        this.content = content;
//        this.brackets = brackets;
//        this.viewCnt = viewCnt;
//
//    }

}
