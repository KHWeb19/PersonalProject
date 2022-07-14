package com.example.backend.service.jpa;

import com.example.backend.entity.jpa.Reservation;
import com.example.backend.entity.jpa.Room;

import java.util.List;

public interface JpaRoomManagerService {

    public List<Room> list( ) throws Exception;

    public void remove(Long bookNo) throws Exception;

    public Room read(Long bookNo) throws Exception;

    // date
    public List<Reservation> bookList( ) throws Exception;
}
