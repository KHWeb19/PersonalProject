package com.example.demo.entity.boardComment;

import com.example.demo.entity.booking.BookingInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "board_comment")
public class BoardComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentNo;

    @Column(length = 32, nullable = false)
    private String id;

    @Column(length = 128, nullable = false)
    private String comments;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "booking_no")
    private BookingInfo bookingInfo;

    @Column(length = 128, nullable = true)
    private String commentLinkInfo;

    @Column(nullable = false)
    private Long parentNo;

    @Column(nullable = false)
    private Long childrenNo;


    @CreatedDate
    @Column(length = 128, nullable = true)
    private String regDate;

    @PrePersist
    public void onPrePersist(){
        this.regDate = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
    }

    public BoardComment(String id, String comments, String commentLinkInfo){
        this.id = id;
        this.comments = comments;
        this.commentLinkInfo = commentLinkInfo;
    }

    public BoardComment(String id, String comments, String commentLinkInfo, Long parentNo, Long childrenNo, BookingInfo info){
        this.id = id;
        this.comments = comments;
        this.commentLinkInfo = commentLinkInfo;
        this.parentNo = parentNo;
        this.childrenNo = childrenNo;
        bookingInfo = info;
    }

    public BoardComment(String id, String comments){
        this.id = id;
        this.comments = comments;
    }

    public BoardComment(String id, String comments, Long parentNo, Long childrenNo, BookingInfo info){
        this.id = id;
        this.comments = comments;
        this.parentNo = parentNo;
        this.childrenNo = childrenNo;
        bookingInfo = info;
    }

}
