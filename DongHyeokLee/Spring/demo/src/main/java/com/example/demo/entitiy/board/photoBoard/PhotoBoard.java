package com.example.demo.entitiy.board.photoBoard;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@NoArgsConstructor
public class PhotoBoard {
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

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    public PhotoBoard (String fileName) {
        this.fileName = fileName ;
    }


}
