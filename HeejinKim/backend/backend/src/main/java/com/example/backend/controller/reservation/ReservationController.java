package com.example.backend.controller.reservation;


import com.example.backend.controller.board.request.SeatNowRequest;
import com.example.backend.controller.board.request.SeatRequest;
import com.example.backend.entity.Reservation;
import com.example.backend.service.reservation.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/reservation")
@CrossOrigin(origins ="http://localhost:8080", allowedHeaders = "*")
public class ReservationController {

    @Autowired
    private ReservationService rsvService;

    @GetMapping("/pickedSeats")
    public ResponseEntity<List<Reservation>> getPickedSeats(@Param("SeatRequest") SeatRequest seatRequest) throws Exception{
        return new ResponseEntity<List<Reservation>>(rsvService.getPickedSeats(seatRequest),HttpStatus.OK);
    }
    @GetMapping("/getSeat")
    public ResponseEntity<List<Reservation>> getSeat(@Param("Reservation") Reservation reservation) throws Exception{
        return new ResponseEntity<List<Reservation>>(rsvService.getSeat(reservation),HttpStatus.OK);
    }
    @GetMapping("/makeReservation")
    public void makeReservation( @Validated @RequestBody Reservation reservation) throws Exception{

        rsvService.makeReservation(reservation);

    }
    /*

    //조회할때 불러오기 남은 좌석,행,열  다가져오기
    @GetMapping("/check")
    public List<Reservation> getBooking (@Validated @RequestBody Reservation reservation) throws Exception{
        return rsvService.getBooking(reservation);
    }

    //좌석(남은, 행, 열 만) 가져오기
    @GetMapping("/getSeat")
    public Reservation getSeat(@Validated @RequestBody SeatRequest seatRequest) throws Exception{
        return rsvService.getSeat(seatRequest);
    }

    @GetMapping("/makeReservation")
    public void makeReservation(@RequestBody Reservation reservation) throws Exception{

        rsvService.makeReservation(reservation);

    }
    //남은자리 가져오기
    @GetMapping("/restSeats")
    public Reservation getRestSeats(@RequestBody Reservation reservation) {

        return rsvService.getRestSeats(reservation);
    }

    //생성 //일단 int를 void로 바꿈
    @PostMapping("/finish")
    public void createBooking(@RequestParam("seatNumber") String seatNumber) {
         rsvService.createBooking(seatNumber);
    }

    //예약 후 좌석 업데이트 넣기
    @PutMapping("/finish")
    public void updateRestSeats(@RequestParam SeatNowRequest seatNowRequest) {

         rsvService.updateRestSeats(seatNowRequest);
    }

    //삭제
    @DeleteMapping("/delete")
    public void deleteSeat(@PathVariable("seatId") Integer seatNumber) {
        rsvService.remove(seatNumber);
    } 4/26까지 한부분 일단 보류*/



    /*
    @GetMapping("/getReservation")
    public ResponseEntity<List<Search_Reservation>> getReservation(@Param("Search_Reservation") Search_Reservation sr) throws Exception{

        return new ResponseEntity<List<Search_Reservation>>(theaterService.getReservation(sr),HttpStatus.OK);
    }*/
    /*
    @GetMapping("/seat")
    public Reservation restSeat (@RequestBody Reservation reservation) {
        log.info("restSeat()");

        return RsvService.seatInsert(reservation);


    }*/


}
