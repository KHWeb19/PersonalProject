package com.example.demo.controller.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DoctorRequest {
    private Long doctorNo;
    private String major;
    private String name;
    private String information;


    public DoctorRequest (String major, String name, String information) {
        this.major=major;
        this.name=name;
        this.information=information;
    }
}
