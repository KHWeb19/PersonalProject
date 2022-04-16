package com.example.demo.entitiy.board.photoBoard;

import lombok.*;
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
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhotoBoard  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardNo;

    @Column(length = 18, nullable = false)
    private String title;

    @Column(length = 18, nullable = false)
    private String writer;

    @Column
    private String fileName;

    @Lob
    private String content;

    @Column
    private int count;

    /*@CreatedDate
    @Column(length = 128, nullable = false)
    private String regDate;*/
    @CreationTimestamp
    private Date regDate;


    @UpdateTimestamp
    private Date updDate;

    public PhotoBoard (String fileName) {
        this.fileName = fileName ;
    }

    /*@PrePersist
    public void onPrePersist(){
        this.regDate = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));
    }*/


}
