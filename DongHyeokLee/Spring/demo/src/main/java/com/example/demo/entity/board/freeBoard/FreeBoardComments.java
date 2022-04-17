package com.example.demo.entity.board.freeBoard;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FreeBoardComments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentNo;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "board_no")
    private FreeBoard freeBoard;

    @Column(length = 32, nullable = false)
    private String writer;

    @Column(length = 64, nullable = false)
    private String comment;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    /*public FreeBoardComments(String writer, String comment){
            this.writer = writer;
            this.comment = comment;

    }*/

}
