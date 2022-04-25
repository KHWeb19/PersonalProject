package com.example.demo.repository.Appointment;

import com.example.demo.entity.Appointment.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
