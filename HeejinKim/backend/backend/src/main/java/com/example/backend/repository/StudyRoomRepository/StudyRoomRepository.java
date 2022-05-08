/*package com.example.backend.repository.reservation;

import com.example.backend.entity.Member;
import com.example.backend.entity.Reservation;
import com.example.backend.entity.StudyRoom;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface StudyRoomRepository extends JpaRepository<StudyRoom, Long>   {


    @Transactional
    @Query(value = "select * from study_room where reservation_no = :reservationNo" , nativeQuery = true)
    Optional<StudyRoom> findByReservationNo(Long reservationNo);

    //시간당 남은 자리 가져오기
    @Transactional
    @Query(value ="SELECT rest_seats, sr.rows, sr.cols FROM study_room sr, seat_time t WHERE t.seat_time = #{seatTime}", nativeQuery = true)
    List <StudyRoom> getRestSeats(@Param("seatTime") String seatTime);

    //이게 오류남
    //@SQLUpdate (sql = "UPDATE seat_time SET rest_seats = #{restSeats} WHERE seat_time = #{seatTime}")
    //int updateRestSeats(@Param("restSeats") int restSeats, @Param("time") String seatTime);




}

 */
