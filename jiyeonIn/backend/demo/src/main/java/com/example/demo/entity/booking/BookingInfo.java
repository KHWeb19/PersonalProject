package com.example.demo.entity.booking;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

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
    private String linkInfo;

    @Column(length = 32, nullable = true)
    private Long cakeArrNo;

    @Column(length = 32, nullable = true)
    private String design;

    @Column(length = 32, nullable = true)
    private String size;

    @Column(length = 32, nullable = true)
    private String price;

    @CreatedDate
    @Column(length = 128, nullable = false)
    private String regDate;

    @PrePersist
    public void onPrePersist(){
        this.regDate = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
    }

    public BookingInfo(String id, String date, String time, String process, String contents, String linkInfo) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.process = process;
        this.contents = contents;
        this.linkInfo = linkInfo;
    }

    public BookingInfo(String id, String date, String time, String process, String contents, String linkInfo, String design, String size, String price, Long cakeArrNo) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.process = process;
        this.contents = contents;
        this.linkInfo = linkInfo;
        this.design = design;
        this.size = size;
        this.price = price;
        this.cakeArrNo = cakeArrNo;
    }

    public BookingInfo(String id, String date, String time, String process, String contents) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.process = process;
        this.contents = contents;
    }

    public BookingInfo(String id, String date, String time, String process, String contents, String design, String size, String price, Long cakeArrNo) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.process = process;
        this.contents = contents;
        this.design = design;
        this.size = size;
        this.price = price;
        this.cakeArrNo = cakeArrNo;
    }
}

