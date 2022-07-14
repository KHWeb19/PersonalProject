package com.example.backend.repository.jpa;

import com.example.backend.entity.jpa.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JpaRoomRepository extends JpaRepository<Room, Long> {

    @Query
    List<Room> findByUserIdContaining(@Param("userId") String userId);

    @Query("select r from Room r where r.roomId = :roomId")
    List<Room> findByRoomId(@Param("roomId") String roomId);

    @Query("select r from Room r where r.bookNo = :bookNo")
    List<Room> findByBookNo(@Param("bookNo") Long bookNo);

}
