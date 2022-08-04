package com.example.demo.entity.Appointment;


import com.example.demo.entity.Doctor.Doctor;
import com.example.demo.entity.Member.Member;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table ( name = "appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aptNo;

    @NotNull
    @DateTimeFormat(pattern ="yyyy/MM/dd")
    private Date date;

    @NotNull
    @Column(length = 20)
    private String time;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberNo")
    @JsonIgnore
    private Member member;

    @ManyToOne
    @JoinColumn(name = "doctorNo")
    @NotNull
    private Doctor doctor;

    public Appointment (Date date, String time, Member member1, Doctor doctor1) {
        this.date = date;
        this.time = time;
        this.member = member1;
        this.doctor = doctor1;
    }

}


