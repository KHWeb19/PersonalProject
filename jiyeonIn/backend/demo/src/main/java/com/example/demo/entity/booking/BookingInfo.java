package com.example.demo.entity.booking;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
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

    @Column(length = 128, nullable = true)
    private String contents;

    @Column(length = 128, nullable = true)
    private String linkInfo;

    @Column(length = 32, nullable = true)
    private String design;

    @Column(length = 32, nullable = true)
    private String size;

    @Column(length = 32, nullable = true)
    private String price;

    @CreationTimestamp
    private Date regDate;

    public BookingInfo(String id, String date, String time, String contents, String linkInfo) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.contents = contents;
        this.linkInfo = linkInfo;
    }

    public BookingInfo(String id, String date, String time, String contents, String linkInfo,String design, String size, String price) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.contents = contents;
        this.linkInfo = linkInfo;
        this.design = design;
        this.size = size;
        this.price = price;
    }
}