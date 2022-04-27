package com.example.backend.service.reservation;

import com.example.backend.controller.board.request.SeatRequest;
import com.example.backend.entity.Reservation;


import java.util.List;

public interface ReservationService {


    public List<Reservation> getPickedSeats(SeatRequest seatRequest);
    public List<Reservation> getSeat(Reservation reservation);
    public void makeReservation(Reservation reservation);




    /*
    public void seatInsert(Reservation reservation);
    public List<Reservation> list (Long memberNo);
    public void remove (Long seatNo) ;*/

    /* 일단 보류 하기 이부분-----------
    public List<Reservation> getBooking( Reservation reservation);

    public Reservation getSeat (SeatRequest seatRequest);

    public Reservation getRestSeats (Reservation reservation);

    public void createBooking(String seatNumber);

    public void updateRestSeats(SeatNowRequest seatNowRequest);

    public void makeReservation(Reservation reservation);

    public void remove (Integer seatNumber);-------------
    */


    //public void seatRemove (Long seatNo) ;
    //public List<Search_Reservation>getReservation(Search_Reservation movr);
}
