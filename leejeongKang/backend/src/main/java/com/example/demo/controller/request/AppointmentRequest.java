package com.example.demo.controller.request;

import com.example.demo.entity.Doctor.Doctor;
import com.example.demo.entity.Member.Member;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class AppointmentRequest {
    private Date date;
    private String time;

    private Long doctorNo;
    private String doctorName;
    private String major;
    private String information;

    private Long memberNo;
    private String id;
    private String password;
    private String name;
    private String birth;
    private String phone;

    //예약 등록시 사용
    /*public AppointmentRequest (Date date, String time, Long doctorNo, Long memberNo) {
        this.date = date;
        this.time = time;

        this.memberNo = memberNo;
    }*/

    public AppointmentRequest (Long memberNo) {
        this.memberNo = memberNo;
    }
}
