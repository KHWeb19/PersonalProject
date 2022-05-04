package com.example.demo.entity.board.freeBoard;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FreeBoardComments {

    @Id
    @Column(name="comment_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentNo;

    @JsonIgnore
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

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "par_comment_no")
    private FreeBoardComments reply;

    @JsonIgnore
    @OneToMany(mappedBy = "reply", fetch = FetchType.LAZY)
    private List<FreeBoardComments> comments;

    /*public FreeBoardComments(String writer, String comment){
            this.writer = writer;
            this.comment = comment;

    }*/

}
