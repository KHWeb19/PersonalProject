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
    private String seatNumber;

    @Column
    private Integer seatRows;

    @Column
    private Integer seatCols;

    @Column
    private Integer restSeats;



    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_no")
    private Member member;


    //@OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    //private List<StudyRoom> studyRoom=new ArrayList<>();

    public Reservation(Integer seatRows,Integer seatCols,String seatNumber){

        this.seatRows = seatRows;
        this.seatCols = seatCols;
        this.seatNumber = seatNumber;

    }


}
