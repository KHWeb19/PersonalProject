package com.example.demo.repository.Appointment;

import com.example.demo.entity.Appointment.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query(value = "select * from appointment where memberNo in(select memberNo from member where memberNo = :memberNo)", nativeQuery = true)
    List<Appointment> findAllByMemberNo (@Param("memberNo") Long memberNo);

    @Transactional
    @Query(value = "select * from appointment as a where a.memberNo = member.memberNo", nativeQuery = true)
    Optional<Appointment> readById (@Param("memberNo") Long memberNo);

}
