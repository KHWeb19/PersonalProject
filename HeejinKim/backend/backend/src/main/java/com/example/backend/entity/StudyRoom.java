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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long seatNo;

    @Column
    private Long rows;

    @Column
    private Long cols;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "reservation_no")
    private Reservation reservation;

    public StudyRoom(Long rows,Long cols){
        this.rows = rows;
        this.cols = cols;

    }

}*/
