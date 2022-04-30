package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationNo;

    //@Column
    //private String seatTime;

    @Column
    private Long seatNumber;

    @Column
    private Long restSeats;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    @CreationTimestamp
    private Date regDate;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "member_no")
    private Member member;

    /*
    @JsonManagedReference
    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<StudyRoom> studyRoom = new ArrayList<>();

     */

    public Reservation( Date regDate,Long seatNumber,Long restSeats){

        this.regDate = regDate;
        this.seatNumber = seatNumber;
        this.restSeats = restSeats;



    }


}
