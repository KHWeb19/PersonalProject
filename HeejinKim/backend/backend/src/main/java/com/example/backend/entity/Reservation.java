package com.example.backend.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name ="reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationNo;

    @Column(length = 32, nullable = false)
    private String writer;


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "member_no")
    private Member member;

    @OneToOne(mappedBy = "reservation", cascade = CascadeType.ALL)
    private StudyRoom studyRoom;

    public Reservation(String writer,Member tableMember){
        this.writer = writer;
        member = tableMember;

    }


}
