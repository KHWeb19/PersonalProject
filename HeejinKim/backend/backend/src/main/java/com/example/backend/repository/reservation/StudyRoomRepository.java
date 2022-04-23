package com.example.backend.repository.reservation;

import com.example.backend.entity.Reservation;
import com.example.backend.entity.StudyRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Optional;

public interface StudyRoomRepository extends JpaRepository<StudyRoom, Long>   {


    @Transactional
    @Query(value = "select * from study_room where reservation_no = :reservationNo" , nativeQuery = true)
    Optional<StudyRoom> findByReservationNo(Long reservationNo);
}
