package com.example.backend.controller.reservation;


import com.example.backend.entity.Reservation;
import com.example.backend.entity.StudyRoom;
import com.example.backend.service.reservation.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/reservation")
@CrossOrigin(origins ="http://localhost:8081", allowedHeaders = "*")
public class ReservationController {

    @Autowired
    private ReservationService rsvService;

/*
    @GetMapping("/seat")
    public Reservation restSeat (@RequestBody Reservation reservation) {
        log.info("restSeat()");

        return RsvService.seatInsert(reservation);


    }*/

    @GetMapping("/pickedSeats")
    public ResponseEntity<List<Reservation>> getPickedSeats(@Param("Reservation") Reservation reservation) throws Exception{
        return new ResponseEntity<List<Reservation>>(rsvService.getPickedSeats(reservation), HttpStatus.OK);
    }


    @GetMapping("/getStudyRoom")
    public ResponseEntity<List<StudyRoom>> getMovieRoom(@Param("StudyRoom") StudyRoom studyRoom) throws Exception{
        return new ResponseEntity<List<StudyRoom>>(rsvService.getStudyRoom(studyRoom),HttpStatus.OK);
    }


    @GetMapping("/makeReservation")
    public void makeReservation(@Param("Reservation") Reservation reservation) throws Exception{

        rsvService.makeReservation(reservation);
    }


    /*
    @GetMapping("/getReservation")
    public ResponseEntity<List<Search_Reservation>> getReservation(@Param("Search_Reservation") Search_Reservation sr) throws Exception{

        return new ResponseEntity<List<Search_Reservation>>(theaterService.getReservation(sr),HttpStatus.OK);
    }*/

}
