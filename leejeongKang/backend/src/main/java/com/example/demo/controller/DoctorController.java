package com.example.demo.controller;

import com.example.demo.controller.request.DoctorRequest;
import com.example.demo.entity.Board.Board;
import com.example.demo.entity.Doctor.Doctor;
import com.example.demo.service.Doctor.DoctorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/doctor")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class DoctorController {

    @Autowired
    private DoctorService service;

    @PostMapping("/register")
    public void DoctorRegister (@Validated @RequestBody Doctor doctor) {
        log.info("DoctorRegister()");

        service.register(doctor);
    }

    @GetMapping("/list")
    public List<Doctor> DoctorList() {
        log.info("DoctorList()");

        return service.list();
    }

    @GetMapping("/{doctorNo}")
    public Doctor DoctorRead (@PathVariable("doctorNo") Long doctorNo){
        log.info("DoctorRead()");

        return service.read(doctorNo);
    }

    @PutMapping("/{doctorNo}")
    public Doctor DoctorModify (@PathVariable("doctorNo") Long doctorNo,
                              @RequestBody Doctor doctor) {
        log.info("DoctorModify(): " + doctor);

        doctor.setDoctorNo(Long.valueOf(doctorNo));
        service.modify(doctor);

        return doctor;
    }
}
