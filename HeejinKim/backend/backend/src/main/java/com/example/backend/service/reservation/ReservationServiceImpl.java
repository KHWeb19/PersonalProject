package com.example.backend.service.reservation;

import com.example.backend.controller.board.request.SeatNowRequest;
import com.example.backend.controller.board.request.SeatRequest;
import com.example.backend.entity.Board;
import com.example.backend.entity.Reservation;
import com.example.backend.repository.reservation.ReservationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository rsvRepository;

    @Transactional
    @Override
    public Reservation getSeat(SeatRequest seatRequest) {

        Optional<Reservation> seatOptional = rsvRepository.findBySeatNumber(seatRequest.getSeatNumber());

        if (seatOptional.isEmpty()) {
            return null;
        }
        else {
            Reservation reservation = seatOptional.get();
            rsvRepository.save(reservation);

        return seatOptional.get();
    }

    }

    @Transactional
    @Override
    public Reservation getRestSeats(Reservation reservation) {
        return null;
    }

    @Transactional
    @Override
    public void createBooking(String seatNumber) {

        //Optional<SeatRequest> createBookingOptional= rsvRepository.findBySeatNumber();

        SeatRequest seatRequest = new SeatRequest();

        //rsvRepository.save(seatNumber);
    }



    @Transactional
    @Override
    public void updateRestSeats(SeatNowRequest seatNowRequest) {

    }

    @Transactional
    @Override
    public void remove(Integer seatNumber) {
        Optional<Reservation> seatOptional = rsvRepository.findBySeatNumber(seatNumber);

        Reservation reservation = seatOptional.get();

        rsvRepository.deleteById(Long.valueOf(seatNumber));
    }



    @Override
    @Transactional
    public List<Reservation> getBooking(Reservation reservation) {
        return rsvRepository.findAll();
    }
/*

    @Override
    @Transactional
    public Reservation getBooking(SeatRequest seatRequest) {
        Optional<Reservation> maybeReservationBoard = rsvRepository.findBySeatNumber(seatRequest.getSeatNo());
        if (maybeReservationBoard.equals(Optional.empty())) {
            log.info("Can't read board!");
            return null;

        } else {
            Reservation reservation = maybeReservationBoard.get();
            rsvRepository.save(reservation);
            return maybeReservationBoard.get();
        }

    }*/


    @Override
    @Transactional
    public void makeReservation(Reservation reservation) {

        rsvRepository.save(reservation);
    }




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

    }

    @Override
    @Transactional
    public List<StudyRoom> getStudyRoom(StudyRoom room) {
        return studyRoomRepository.findAll();
    }
*/
}
