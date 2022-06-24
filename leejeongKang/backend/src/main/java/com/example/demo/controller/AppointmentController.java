package com.example.demo.controller;

import com.example.demo.controller.request.AppointmentRequest;
import com.example.demo.entity.Appointment.Appointment;
import com.example.demo.entity.Doctor.Doctor;
import com.example.demo.entity.Member.Member;
import com.example.demo.service.Appointment.AppointmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/appointment")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @PostMapping("/register")
    public void AptRegister (@Validated @RequestBody AppointmentRequest appointmentRequest) {
        log.info("AppointmentRegister()");

        service.register(appointmentRequest);
    }

    @GetMapping("/{memberNo}")
    public List<Appointment> AptList(@PathVariable("memberNo") Long memberNo) {
        log.info("AptList()");

        return service.list(memberNo);
    }

    /*@GetMapping("/{memberNo}")
    public Appointment AptRead (@PathVariable("memberNo") Long memberNo) {
        log.info("AptRead()");

        return service.read(memberNo);
    }
*/
    @DeleteMapping("/{memberNo}")
    public void AptDelete (@PathVariable("aptNo") Long aptNo) {
        log.info("AptDelete()");

        service.read(aptNo);
    }
}
