package com.example.backend.repository.jpa;

import com.example.backend.entity.jpa.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface JpaReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("select e from Reservation e where e.reservedDate = :reservedDate")
    List<Reservation> findByDate(@Param("reservedDate") Date reservedDate);

    @Query("select e from Reservation e where e.bookNo = :bookNo")
    Optional<Reservation> findByBookNo(@Param("bookNo") Long bookNo);

    @Query
    List<Reservation> findByBookNoContaining(@Param("bookNo") Long bookNo);

}
