package com.example.demo.entity.board.photoBoard;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PhotoBoardLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeNo;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "board_no")
    private PhotoBoard photoBoard;

    @Column(nullable = false)
    private String writer;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;
}
