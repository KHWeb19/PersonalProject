package com.example.demo.service.Appointment;

import com.example.demo.controller.request.AppointmentRequest;
import com.example.demo.entity.Appointment.Appointment;
import com.example.demo.entity.Doctor.Doctor;
import com.example.demo.entity.Member.Member;

import java.util.List;

public interface AppointmentService {

    //예약 등록, 읽기, 삭제
    public void register (AppointmentRequest appointmentRequest);
    public List<Appointment> list();
    // public List<Appointment> list(Long memberNo);
    public void remove (Long aptNo);
}
