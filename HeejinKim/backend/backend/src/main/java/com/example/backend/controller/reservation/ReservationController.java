package com.example.backend.controller.reservation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/reservation")
@CrossOrigin(origins ="http://localhost:8081", allowedHeaders = "*")
public class ReservationController {


}
