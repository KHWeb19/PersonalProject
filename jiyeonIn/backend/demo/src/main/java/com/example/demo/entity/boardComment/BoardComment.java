package com.example.demo.entity.boardComment;

import com.example.demo.entity.booking.BookingInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Data
@Entity
@NoArgsConstructor
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

    public BoardComment(String id, String comments, String commentLinkInfo, BookingInfo info){
        this.id = id;
        this.comments = comments;
        this.commentLinkInfo = commentLinkInfo;
        bookingInfo = info;
    }

    public BoardComment(String id, String comments){
        this.id = id;
        this.comments = comments;
    }

    public BoardComment(String id, String comments, BookingInfo info){
        this.id = id;
        this.comments = comments;
        bookingInfo = info;
    }

}
