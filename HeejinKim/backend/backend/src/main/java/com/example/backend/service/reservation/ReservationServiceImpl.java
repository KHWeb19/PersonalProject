package com.example.backend.service.reservation;

import com.example.backend.controller.board.request.SeatRequest;
import com.example.backend.entity.Board;
import com.example.backend.entity.BoardComments;
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


    //리스트 가져오기
    @Transactional
    @Override
    public List<Reservation> list() {

        return rsvRepository.findAll(Sort.by(Sort.Direction.DESC, "reservationNo"));
    }

    //예약시 등록하기(예약 번호는 자동으로,( 자리번호, 시간(당일), 글쓴이), 멤버번호(조인컬럼))
    @Transactional
    @Override
    public void rsvRegister(Reservation reservation) {

        rsvRepository.save(reservation);

    }

    //userId를 넣으면 그 예약을 조회가능하도록 (= read기능과 비슷)
    @Transactional
    @Override
    public Reservation getBookingRead(Long reservationNo) {//원래 userId넣어야 되는데 생각중
        Optional<Reservation> maybeGetBookingRead = rsvRepository.findById(reservationNo);

        if (maybeGetBookingRead.equals(Optional.empty())) {
            log.info("Can't get BookingRead!");
            return null;
        }

        return maybeGetBookingRead.get();
    }

    //시간을 넣어서 예약들 찾아오기
    @Override
    public Reservation getRestSeats(String seatTime) {

        Optional<Reservation> maybeGetRestSeats = rsvRepository.findRestSeatsByTime(seatTime);
        if (maybeGetRestSeats.equals(Optional.empty())) {
            log.info("Can't get getRestSeats!");
            return null;
        }

        return maybeGetRestSeats.get();
    }

    //업데이트 된 내용을 넣기
    @Transactional
    @Override
    public void updateModify(Reservation reservation) {


        rsvRepository.save(reservation);

    }

    //삭제
    @Transactional
    @Override
    public void remove(Long reservationNo) {

        rsvRepository.deleteById(reservationNo);
    }
    @Transactional
    @Override
    public List<Reservation> searchIdList(String searchId) {
        return rsvRepository.findIdList(searchId);

    }



    @Transactional //아이디 넣고 리스트 불러올때
    @Override
    public Reservation read(Long checkReservationNo, String searchId) {
        Optional<Reservation> maybeReadBoard = rsvRepository.findById(checkReservationNo);

        if(maybeReadBoard.equals(Optional.empty())){
            log.info("no booking");
        }

        Reservation rsvId = maybeReadBoard.get();

        if(rsvId.getId().equals(searchId)){
            log.info("searchId:"+searchId);
            return rsvId;
        }else if(searchId.equals("manager")) {
            log.info("callBookingList");
            return rsvId;
        }else
            return null;


    }
}
    /*


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

    }*/

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

