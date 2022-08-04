package com.example.demo.repository.Appointment;

import com.example.demo.entity.Appointment.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    /*@Transactional
    @Query(value = "select a from Appointment as a join a.memberNo m where m.memberNo = :memberNo")
    List<Appointment> findAllByMemberNo (@Param("memberNo") Long memberNo);

    @Transactional
    @Query(value = "select * from appointment as a where a.memberNo = member.memberNo", nativeQuery = true)
    Optional<Appointment> readById (@Param("memberNo") Long memberNo);
*/
}
