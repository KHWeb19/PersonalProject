package com.example.backend.service.jpa;

import com.example.backend.controller.reservation.request.DateRequest;
import com.example.backend.controller.reservation.request.RoomRequest;
import com.example.backend.entity.jpa.Room;

import java.util.Date;
import java.util.List;

public interface JpaRoomService {

    public void bookRoom(RoomRequest roomRequest) throws Exception;

    public List<RoomRequest> bookList(String userId) throws Exception;

    public boolean checkRoom(RoomRequest roomRequest) throws Exception;

    public Room read(Long bookNo) throws Exception;

    public void remove(Long bookNo) throws Exception;

    // 캘린더 체크
    public Date changeDate(DateRequest dateRequest) throws Exception;

    public List<RoomRequest> checkIn(Date reservedDate) throws Exception;

}
