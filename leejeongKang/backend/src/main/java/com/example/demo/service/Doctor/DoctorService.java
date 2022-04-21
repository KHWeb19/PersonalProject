package com.example.demo.service.Doctor;

import com.example.demo.controller.request.DoctorRequest;
import com.example.demo.entity.Doctor.Doctor;

import java.util.List;

public interface DoctorService {

    public void register (Doctor doctor);
    public List<Doctor> list();
    public Doctor read (Long doctorNo);
    public void modify (Doctor doctorNo);
    public void remove (Long doctorNo);
}
