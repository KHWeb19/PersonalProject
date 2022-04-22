package com.example.demo.entity.Appointment;


import com.example.demo.entity.Doctor.Doctor;
import com.example.demo.entity.Member.Member;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table ( name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aptNo;

    @DateTimeFormat(pattern ="yyyy/MM/dd")
    private Date date;

    @Column(length = 20, nullable = false)
    private String time;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "memberNo")
    private Member member;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "doctorNo")
    private Doctor doctor;
}


