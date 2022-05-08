/*package com.example.backend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "study_room")
public class StudyRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seatRsvNo;

    @Column
    private String seatRows;

    @Column
    private String seatCols;

    @Column
    private int restSeats;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_no")
    private Reservation reservation;

    public StudyRoom(String seatRows,String seatCols){
        this.seatRows = seatRows;
        this.seatCols = seatCols;

    }

}*/
