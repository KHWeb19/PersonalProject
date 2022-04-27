package com.example.demo.entity.booking;

import com.example.demo.entity.boardComment.BoardComment;
import com.example.demo.entity.member.Member;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "booking_info")
public class BookingInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingNo;

    @Column(length = 32, nullable = false)
    private String id;

    @Column(length = 32, nullable = false)
    private String date;

    @Column(length = 32, nullable = false)
    private String time;

    @Column(length = 32, nullable = false)
    private String process;

    @Column(length = 128, nullable = true)
    private String contents;

    @Column(length = 128, nullable = true)
    private String cakeLinkInfo;

    @Column(length = 128, nullable = true)
    private String linkInfo;

    @Column(length = 32, nullable = true)
    private String design;

    @Column(length = 32, nullable = true)
    private String size;

    @Column(length = 32, nullable = true)
    private String price;

    @CreatedDate
    @Column(length = 128, nullable = true)
    private String regDate;

    @PrePersist
    public void onPrePersist(){
        this.regDate = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
    }

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "bookingInfo", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<BoardComment> commentList = new ArrayList();

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "member_no")
    private Member memberInfo;


    public BookingInfo(String id, String date, String time, String process, String contents, String linkInfo) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.process = process;
        this.contents = contents;
        this.linkInfo = linkInfo;
    }

    public BookingInfo(String id, String date, String time, String process, String contents, String linkInfo, Member member) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.process = process;
        this.contents = contents;
        this.linkInfo = linkInfo;
        memberInfo = member;
    }

    public BookingInfo(String id, String date, String time, String process, String contents, String linkInfo, BoardComment boardComment) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.process = process;
        this.contents = contents;
        this.linkInfo = linkInfo;

        if(boardComment != null) {
            changeComment(boardComment);
        }
    }

    private void changeComment(BoardComment boardComment) {
    }

    public BookingInfo(String id, String date, String time, String process, String contents, String linkInfo, String cakeLinkInfo, String design, String size, String price) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.process = process;
        this.contents = contents;
        this.linkInfo = linkInfo;
        this.cakeLinkInfo = cakeLinkInfo;
        this.design = design;
        this.size = size;
        this.price = price;
    }

    public BookingInfo(String id, String date, String time, String process, String contents, String linkInfo, String cakeLinkInfo, String design, String size, String price, Member member) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.process = process;
        this.contents = contents;
        this.linkInfo = linkInfo;
        this.cakeLinkInfo = cakeLinkInfo;
        this.design = design;
        this.size = size;
        this.price = price;
        memberInfo = member;
    }

    public BookingInfo(String id, String date, String time, String process, String contents, String linkInfo, String cakeLinkInfo, String design, String size, String price, BoardComment boardComment) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.process = process;
        this.contents = contents;
        this.linkInfo = linkInfo;
        this.cakeLinkInfo = cakeLinkInfo;
        this.design = design;
        this.size = size;
        this.price = price;

        if(boardComment != null) {
            changeComment(boardComment);
        }
    }



    public BookingInfo(String id, String date, String time, String process, String contents) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.process = process;
        this.contents = contents;
    }

    public BookingInfo(String id, String date, String time, String process, String contents, Member member) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.process = process;
        this.contents = contents;
        memberInfo = member;
    }

    public BookingInfo(String id, String date, String time, String process, String contents, BoardComment boardComment) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.process = process;
        this.contents = contents;

        if(boardComment != null) {
            changeComment(boardComment);
        }
    }

    public BookingInfo(String id, String date, String time, String process, String contents, String cakeLinkInfo, String design, String size, String price) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.process = process;
        this.contents = contents;
        this.cakeLinkInfo = cakeLinkInfo;
        this.design = design;
        this.size = size;
        this.price = price;
    }

    public BookingInfo(String id, String date, String time, String process, String contents, String cakeLinkInfo, String design, String size, String price, Member member) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.process = process;
        this.contents = contents;
        this.cakeLinkInfo = cakeLinkInfo;
        this.design = design;
        this.size = size;
        this.price = price;
        memberInfo = member;
    }

    public BookingInfo(String id, String date, String time, String process, String contents, String cakeLinkInfo, String design, String size, String price, BoardComment boardComment) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.process = process;
        this.contents = contents;
        this.cakeLinkInfo = cakeLinkInfo;
        this.design = design;
        this.size = size;
        this.price = price;

        if(boardComment != null) {
            changeComment(boardComment);
        }
    }
}

