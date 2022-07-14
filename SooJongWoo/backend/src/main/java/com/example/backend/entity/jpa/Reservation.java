package com.example.backend.entity.jpa;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Table(name="reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationNo;

    @Column(name = "book_no")
    private Long bookNo;

    @Temporal(TemporalType.DATE)
    private Date reservedDate; // 예약할 날짜

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    @CreationTimestamp
    private Date regDate; // 예약을 언제했는지   - 7/30

    @UpdateTimestamp
    private Date updDate;

    @Builder
    public Reservation(Date reservedDate) {
        this.reservedDate = reservedDate;
    }
}
