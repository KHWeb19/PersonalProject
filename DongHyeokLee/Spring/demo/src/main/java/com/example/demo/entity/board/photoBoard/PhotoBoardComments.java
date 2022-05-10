package com.example.demo.entity.board.photoBoard;

import com.example.demo.entity.board.freeBoard.FreeBoard;
import com.example.demo.entity.board.freeBoard.FreeBoardComments;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PhotoBoardComments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentNo;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "board_no")
    private PhotoBoard photoBoard;

    @Column(length = 32, nullable = false)
    private String writer;

    @Column(length = 64, nullable = false)
    private String comment;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "par_comment_no")
    private PhotoBoardComments reply;

    @JsonIgnore
    @OneToMany(mappedBy = "reply", fetch = FetchType.LAZY)
    private List<PhotoBoardComments> comments;

    /*public PhotoBoardComments(String writer, String comment, Long boardNo){
        this.writer = writer;
        this.comment = comment;
        this.boardNo = boardNo;
    }*/

}
