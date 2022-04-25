package com.example.demo.entity.Doctor;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table (name = "doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctorNo;

    @Column(length = 20, nullable = false)
    private String doctorName;

    @Column(length = 20, nullable = false)
    private String major;

    @Lob
    private String information;

    public Doctor(Long doctorNo) {
        this.doctorNo = doctorNo;
        this.doctorName=doctorName;
        this.major=major;
        this.information=information;
    }
}

