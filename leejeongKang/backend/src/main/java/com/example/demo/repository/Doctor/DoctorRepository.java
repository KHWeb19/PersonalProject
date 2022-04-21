package com.example.demo.repository.Doctor;

import com.example.demo.entity.Doctor.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
