package com.example.backend.repository.centerBoard;

import com.example.backend.entity.Board;
import com.example.backend.entity.Center;
import com.example.backend.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface CenterRepository extends JpaRepository<Center, Long> {
    List<Center> findByTitleContaining(String keyWord);

    @Transactional
    @Query(value = "select * from center where writer = :searchId",nativeQuery = true)
    public List<Center> findIdList(String searchId);

}
