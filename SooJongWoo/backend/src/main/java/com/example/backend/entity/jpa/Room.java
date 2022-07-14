package com.example.backend.entity.jpa;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name="room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_no")
    private Long bookNo;

    @Column(length = 64, nullable = false)
    private String roomId;

    @Column(length = 64, nullable = false)
    private String period;

    @Column(length = 64, nullable = false)
    private String personNum;

    @Column(length = 64, nullable = false)
    private String bankName;

    @Column(length = 64, nullable = false)
    private String price;

    @Column(length = 64, nullable = false)
    private String userId;

    @Column(length = 64, nullable = false)
    private Integer roomCnt;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date updDate;



    //     조인컬럼으로 reservationDate 가져오기 == 예약일
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "book_no")
    private List<Reservation> dateList = new ArrayList<Reservation>();

    @Builder
    public Room(String roomId, String period, String personNum, String bankName, String price, String userId, Integer roomCnt, Date regDate) {
        this.roomId = roomId;
        this.period = period;
        this.personNum = personNum;
        this.bankName = bankName;
        this.price = price;
        this.userId = userId;
        this.roomCnt = roomCnt;
        this.regDate = regDate;
    }

    public void addDate(Reservation date) {
        dateList.add(date);
    }

    public void clearDateList () {
        dateList.clear();
    }

}
