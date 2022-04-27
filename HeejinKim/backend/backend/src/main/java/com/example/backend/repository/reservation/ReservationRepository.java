package com.example.backend.repository.reservation;

import com.example.backend.controller.board.request.SeatRequest;

import com.example.backend.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Transactional
    @Query(value = "select * from reservation where member_no = :memberNo" , nativeQuery = true)
    List<Reservation> findByMemberNo(Long memberNo);

    @Transactional
    @Query(value = "select * from reservation where seat_num = :seatNum" , nativeQuery = true)
    Optional<Reservation> findBySeatNum(Integer seatNum);

    //@Transactional
   // List<SeatRequest> getPickedSeats(SeatRequest seatRequest);

   // @Transactional
    //List<Reservation> getSeat(Reservation reservation);

    //public void makeReservation(SeatRequest seatRequest);


}

