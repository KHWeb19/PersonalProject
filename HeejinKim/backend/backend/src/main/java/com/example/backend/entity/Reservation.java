package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(length = 32, nullable = false)
    private String id;

    //@Column
    //private String seatTime;

    @Column
    private String seatNumber;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd ", timezone = "Asia/Seoul")
    @CreationTimestamp
    private Date regDate;

    @JsonIgnore
    //@JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "member_no")
    private Member member;


    public Reservation ( String id,String seatNumber,Member tableMember){
        this.id = id;
        this.seatNumber = seatNumber;
        member = tableMember;

    }

    /*
    @JsonManagedReference
    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<StudyRoom> studyRoom = new ArrayList<>();



    public Reservation( Date regDate,String seatNumber){

        this.regDate = regDate;
        this.seatNumber = seatNumber;


    }*/


}
