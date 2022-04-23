package com.example.backend.repository.reservation;

import com.example.backend.entity.Board;
import com.example.backend.entity.MemberAuth;
import com.example.backend.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Optional;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Transactional
    @Query(value = "select * from reservation where member_no = :memberNo" , nativeQuery = true)
    Optional<Reservation> findByMemberNo(Long memberNo);

}

