package com.example.backend.service.jpa;

import com.example.backend.entity.jpa.Reservation;
import com.example.backend.entity.jpa.Room;
import com.example.backend.repository.jpa.JpaReservationRepository;
import com.example.backend.repository.jpa.JpaRoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class JpaRoomManagerServiceImpl implements JpaRoomManagerService {

    @Autowired
    private JpaRoomRepository roomRepository;

    @Autowired
    private JpaReservationRepository reservationRepository;

    @Override
    public List<Room> list() throws Exception {
        return roomRepository.findAll();
    }

    @Override
    public void remove(Long bookNo) throws Exception {
        roomRepository.deleteById(bookNo);
    }

    @Override
    public Room read(Long bookNo) throws Exception {
        Optional<Room> memberDetail = roomRepository.findById(bookNo);
        if(memberDetail.isPresent()) {
            Room room = memberDetail.get();
            roomRepository.save(room);

            return room;
        } else {
            throw new NullPointerException();
        }

    }

    //reservationDate
    public List<Reservation> bookList( ) throws Exception {
        return reservationRepository.findAll();
    }



}
