package com.example.demo.controller.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DoctorRequest {
    private Long doctorNo;
    private String major;
    private String doctorName;
    private String information;


    public DoctorRequest (String major, String doctorName, String information) {
        this.major=major;
        this.doctorName=doctorName;
        this.information=information;
    }
}
