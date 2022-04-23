package com.example.backend.service.reservation;

import com.example.backend.entity.BoardComments;
import com.example.backend.entity.Reservation;
import com.example.backend.entity.StudyRoom;
import com.example.backend.repository.reservation.ReservationRepository;
import com.example.backend.repository.reservation.StudyRoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository rsvRepository;

    @Autowired
    private StudyRoomRepository studyRoomRepository;
/*
    @Transactional
    @Override
    public void seatInsert(Reservation reservation) {

    }

    @Transactional
    @Override
    public List<Reservation> list(Long memberNo) {
          rsvRepository.findByMemberNo(memberNo);;
        return list(memberNo);
    }

    @Transactional
    @Override
    public void remove(Long seatNo) {

    }*/

    @Override
    @Transactional
    public List<Reservation> getPickedSeats(Reservation reservation) {
        return rsvRepository.findAll(Sort.by(Sort.Direction.DESC, "reservationNo"));
    }

    @Override
    @Transactional
    public List<StudyRoom> getStudyRoom(StudyRoom room) {
        return studyRoomRepository.findAll();
    }

    @Override
    @Transactional
    public void makeReservation(Reservation reservation) {

        rsvRepository.save(reservation);
    }
}
