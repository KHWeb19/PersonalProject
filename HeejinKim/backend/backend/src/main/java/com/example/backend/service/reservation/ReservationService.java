package com.example.backend.service.reservation;

import com.example.backend.controller.board.request.CommentRequest;
import com.example.backend.controller.board.request.SeatRequest;
import com.example.backend.entity.Board;
import com.example.backend.entity.Reservation;


import java.util.List;

public interface ReservationService {

    //Id 넣으면 조회 가능하게
    //예매내역 추가하기

    public List<Reservation> list ();
    public void rsvRegister (Reservation reservation);          //내역 추가하기
    public Reservation getBookingRead (Long reservationNo);     //Id 넣으면 조회 가능하게---예약번호넣으면 조회가능하게
    public void updateModify (Reservation reservation);         //업데이트 된 내용을 넣기
    public void remove (Long reservationNo) ;                   //삭제기능
    public Reservation getRestSeats (String seatTime);          //시간으로 남은자리 찾기
    public List<Reservation> searchIdList(String searchId);
    public Reservation read (Long checkReservationNo,String searchId);



     /* 이게 오류남 바로 넣는게
    @SQLInsert(sql = "INSERT INTO booking ( time, seat_number,) VALUES (#{time}, #{seatNumber})")
    int insertBooking(@Param("time") String time, @Param("seatNumber") String seatNumber);
    */

}

    /*
    public List<Reservation> getPickedSeats(SeatRequest seatRequest);
    public List<Reservation> getSeat(Reservation reservation);
    public void makeReservation(Reservation reservation);
    */





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

