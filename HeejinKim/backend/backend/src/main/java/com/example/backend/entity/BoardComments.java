package com.example.backend.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class BoardComments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentNo;

    @Column(length = 32, nullable = false)
    private String commentWriter;

    @Column(length = 128, nullable = false)
    private String comment;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="board_no")
    private Board board;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    public BoardComments(Long commentNo, String comment, Date regDate) {

        this.comment = comment;
        this.commentNo = commentNo;
        this.regDate = regDate;
    }

}
