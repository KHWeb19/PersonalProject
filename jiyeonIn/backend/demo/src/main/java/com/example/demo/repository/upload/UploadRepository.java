package com.example.demo.repository.upload;


import com.example.demo.entity.uploadCake.UploadCake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UploadRepository extends JpaRepository<UploadCake, Long> {

    @Query(value = "select * from upload_cake where cake_no = :cakeNo",nativeQuery = true)
    Optional<UploadCake> findInfo(Long cakeNo);
}
