package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer seatNum;

    @Column
    private Integer seatRows;

    @Column
    private Integer seatCols;


    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_no")
    private Member member;


    //@OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    //private List<StudyRoom> studyRoom=new ArrayList<>();

    public Reservation(Integer seatRows,Integer seatCols,Integer seatNum){

        this.seatRows = seatRows;
        this.seatCols = seatCols;
        this.seatNum = seatNum;

    }


}
