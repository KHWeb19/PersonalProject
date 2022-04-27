package com.example.backend.service.reservation;

import com.example.backend.controller.board.request.SeatRequest;
import com.example.backend.entity.Board;
import com.example.backend.entity.Reservation;
import com.example.backend.repository.reservation.ReservationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository rsvRepository;

    @Override
    public List<Reservation> getPickedSeats(SeatRequest seatRequest) {


        return rsvRepository.findAll();

        }



    @Override
    public List<Reservation> getSeat(Reservation reservation) {
        Optional<Reservation> seatOptional = rsvRepository.findBySeatNum(reservation.getSeatNum());

        if (seatOptional.isEmpty()) {
            return null;
        }
        else {
            reservation = seatOptional.get();
            rsvRepository.save(reservation);

            return (List<Reservation>) seatOptional.get();
        }

        //return rsvRepository.getSeat(reservation);


    }

    @Override
    public void makeReservation(Reservation reservation) {

        Optional<Reservation> maybeReservation = rsvRepository.findBySeatNum(reservation.getSeatNum());

        rsvRepository.save(reservation);

    }
    /*----------일단 이부분 보류

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
    @Override
    @Transactional
    public void makeReservation(Reservation reservation) {

        rsvRepository.save(reservation);
    }----------------------*/

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
