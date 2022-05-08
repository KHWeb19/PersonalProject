package com.example.backend.repository.reservation;

import com.example.backend.controller.board.request.SeatNowRequest;
import com.example.backend.controller.board.request.SeatRequest;

import com.example.backend.entity.Member;
import com.example.backend.entity.MemberAuth;
import com.example.backend.entity.Reservation;
import org.hibernate.annotations.SQLInsert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Transactional
    @Query(value = "select * from reservation where user_id = :userId", nativeQuery = true)
    Optional <Reservation> findByUserId(String userId);

    @Transactional
    @Query(value = "select * from member_auth where member_no = :memberNo" , nativeQuery = true)
    Optional<Reservation> findByMemberNo(Long memberNo);


    //좌석번호로 예약 다 가져오기 ---이건 좌석번호 하나만 가능한거니까--- 시간은 다가져올 수 있음
    @Transactional
    @Query(value = "select * from reservation where seat_number = :seatNumber", nativeQuery = true)
    Optional<Reservation> findBySeatNumber(Long seatNumber);

    //시간으로 예약 다 가져오기
    @Transactional
    @Query(value = "select * from reservation where seat_time = :seatTime", nativeQuery = true)
    Optional <Reservation> findRestSeatsByTime(String seatTime);


    @Transactional
    @Query(value = "select * from reservation where id = :searchId",nativeQuery = true)
    public List<Reservation> findIdList(String searchId);










}

    /* 이게 오류남 바로 넣는게
    @SQLInsert(sql = "INSERT INTO booking ( time, seat_number,) VALUES (#{time}, #{seatNumber})")
    int insertBooking(@Param("time") String time, @Param("seatNumber") String seatNumber);
    */




    //@Transactional
   // List<SeatRequest> getPickedSeats(SeatRequest seatRequest);

   // @Transactional
    //List<Reservation> getSeat(Reservation reservation);

    //public void makeReservation(SeatRequest seatRequest);




