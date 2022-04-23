package com.example.demo.repository.upload;


import com.example.demo.entity.uploadCake.UploadCake;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UploadRepository extends JpaRepository<UploadCake, Long> {
}
