package com.example.demo.service.Appointment;

import com.example.demo.entity.Appointment.Appointment;

import java.util.List;

public interface AppointmentService {

    //예약 등록, 읽기, 삭제
    public void register (Appointment appointment);
    public List<Appointment> list();
    public Appointment read (Long aptNo);
    public void remove (Long aptNo);
}
