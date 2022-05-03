package com.example.demo.entity.board.videoBoard;

import com.example.demo.entity.board.photoBoard.PhotoBoard;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VideoBoardComments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentNo;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "board_no")
    private VideoBoard videoBoard;

    @Column(length = 32, nullable = false)
    private String writer;

    @Column(length = 64, nullable = false)
    private String comment;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;


}
