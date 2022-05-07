package com.example.backend.controller.reservation;

import com.example.backend.controller.board.request.SeatNowRequest;
import com.example.backend.entity.Reservation;
import com.example.backend.service.reservation.ReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/reservation")
@CrossOrigin(origins ="http://localhost:8080", allowedHeaders = "*")
public class ReservationController {

    @Autowired
    private ReservationService rsvService;

    //1)등록 2) 수정 (업데이트) 3) 리스트 가져오기 4) 읽기 5) 삭제

    //디비로 확정 정보 넣기--원래 @RequestParam("time") String time,@RequestParam("seatNumber") String seatNumber 들어가는데 다 넣음
    @PostMapping("/finish")
    public void rsvRegister(@Validated @RequestBody Reservation reservation) {

        log.info("rsvRegister()");

        rsvService.rsvRegister(reservation);
    }

    //시간으로 예약자리 찾기
    @GetMapping("/getSeats")
    public Reservation getRestSeats (@RequestParam("seatTime") String seatTime){
        log.info("getSeats()");

        return rsvService.getRestSeats(seatTime);
    }

    //리스트 가져오기---전체 자리 읽어오기
    @GetMapping("/reservationList")
    public List<Reservation> reservationListList() {
        log.info("reservationListList()");

        return rsvService.list();
    }



    //Id로 예약내역 조회---userId를 넣어야하는데 일단 보류
    //일단 레포지토리나 서비스에서 id로 찾기를 하기 때문에 여기서 예약 번호를 넣음
    @GetMapping("/checkBooking/{reservationNo}")
    public Reservation getBookingRead(@PathVariable("reservationNo") Long reservationNo) {

        log.info("getBookingRead()");
        return rsvService.getBookingRead(reservationNo);
    }

    //업데이트 사항 넣기
    @PutMapping("/update")
    public Reservation updateModify(@Validated @RequestBody Reservation reservation) {
        log.info("updateModify(): " + reservation);

        //reservation.setReservationNo(reservationNo);
        rsvService.updateModify(reservation);

        return reservation;
    }


    //삭제
    @DeleteMapping("/{reservationNo}")
    public void reservationRemove(
            @PathVariable("reservationNo") Long reservationNo) {
        log.info("reservationRemove()");

        rsvService.remove(reservationNo);
    }


    //업데이트된 정보 넣기
    @PutMapping("/finish/{reservationNo}")
    public Reservation updateReservationModify(
            @PathVariable("reservationNo") Long reservationNo,
            @RequestBody Reservation reservation) {
        log.info("updateReservation(): " + reservation);

        reservation.setReservationNo(reservationNo);
        rsvService.updateModify(reservation);

        return reservation;
    }
    // 내 예약 정보 불러올때
    @GetMapping("/list/{searchId}")
    public List<Reservation> ReservationPerList (@PathVariable("searchId") String searchId) {
        log.info("reservationPerList()");


        return rsvService.searchIdList(searchId);
    }

    @RequestMapping(value = "/read",  method = RequestMethod.GET)
    public Reservation bookingReadBoard (@RequestParam(value = "checkReservationNo", required = false) Long checkReservationNo,
                                         @RequestParam(value = "searchId", required = false) String searchId) {


        log.info("checkReservationNo:" +checkReservationNo + "id:" +searchId);

        return rsvService.read(checkReservationNo,searchId);
    }
}
/* 여기서는 행,열만 업데이트 되기 때문에 필요없을 것 같아서 삭제
    //자리 배열 업데이트
    @PutMapping("/finish/{seatRsvNo}")
    public StudyRoom updateStudyRoomModify (
            @PathVariable("seatRsvNo") Long seatRsvNo,
            @RequestBody StudyRoom studyRoom) {
        log.info("updateReservation(): " + studyRoom);

        studyRoom.setSeatRsvNo(seatRsvNo);
        srService.updateSeat(studyRoom);

        return studyRoom;
    }

 */
    //디비로 자리 배열 넣기
    /*
    @PostMapping("/finish/seat")
    public void insertBookingSeat ( @Validated @RequestBody StudyRoom studyRoom) {

        log.info("insertBookingSeat()");

        srService.seatRegister(studyRoom);
    }

     */

    /* 일단 시간을 넣었을 때 남은 자리를 가져오는 것을 일단 보류--업데이트 정보 넣기가 있으니까
    //남은자리 가져오기
    @GetMapping("/seat")
    public Reservation getRestSeats(@RequestParam("seatTime") String seatTime ) {
        log.info(seatTime);

        return rsvService.getRestSeats(seatTime);
    }*/






    //자리 확정 후 남은 자리 업데이트
    /*@PutMapping("/finish")
    public int updateRestSeats(@RequestParam("restSeats") int restSeats, @RequestParam("time") String time) {

        log.info("**************");
        return studyRoomRepository.updateRestSeats(restSeats, time);

    }*/
// @Autowired
    //private ReservationRepository reservationRepository;

    //@Autowired
    // private StudyRoomRepository studyRoomRepository;
    /*
    //자리 확정 후 남은 자리 업데이트

    @PutMapping("/finish")
    public int updateRestSeats(@RequestParam("restSeats") int restSeats, @RequestParam("time") String time) {

        log.info("**************");
        return studyRoomRepository.updateRestSeats(restSeats, time);

    }

    //디비로 확정 정보 넣기---일단 바로 레포지토리로 넣기
    @PostMapping("/finish")
    public int insertBooking( @RequestParam("time") String time,@RequestParam("seatNumber") String seatNumber) {

        log.info("&&&&&&&&&&&&&&&&");
        return rsvService.insertBooking( time, seatNumber);
    }

    //전체 자리 (행,열) 남은자리 가져오기
    @GetMapping("/seat")
    public StudyRoom getRestSeats(@RequestParam("seatTime") String seatTime ) {
        log.info(seatTime);

        return (StudyRoom) studyRoomRepository.getRestSeats(seatTime);
    }

    //Id로 예약내역 조회---레포지토리에 @select으로 만들어놓음
   @GetMapping("/checkBooking/{userId}")
    public List<Reservation> getBooking(@PathVariable("userId") String userId) {

        log.info("*****************");
        return rsvService.findByUserId(userId);
    }*/







    /*

    @GetMapping("/pickedSeats")
    public ResponseEntity<List<Reservation>> getPickedSeats(@Param("SeatRequest") SeatRequest seatRequest) throws Exception{
        return new ResponseEntity<List<Reservation>>(rsvService.getPickedSeats(seatRequest),HttpStatus.OK);
    }
    @GetMapping("/getSeat")
    public ResponseEntity<List<Reservation>> getSeat(@Param("Reservation") Reservation reservation) throws Exception{
        return new ResponseEntity<List<Reservation>>(rsvService.getSeat(reservation),HttpStatus.OK);
    }
    @GetMapping("/makeReservation")
    public void makeReservation( @Validated @RequestBody Reservation reservation) throws Exception{

        rsvService.makeReservation(reservation);

    }*/
    /*

    //조회할때 불러오기 남은 좌석,행,열  다가져오기
    @GetMapping("/check")
    public List<Reservation> getBooking (@Validated @RequestBody Reservation reservation) throws Exception{
        return rsvService.getBooking(reservation);
    }

    //좌석(남은, 행, 열 만) 가져오기
    @GetMapping("/getSeat")
    public Reservation getSeat(@Validated @RequestBody SeatRequest seatRequest) throws Exception{
        return rsvService.getSeat(seatRequest);
    }

    @GetMapping("/makeReservation")
    public void makeReservation(@RequestBody Reservation reservation) throws Exception{

        rsvService.makeReservation(reservation);

    }
    //남은자리 가져오기
    @GetMapping("/restSeats")
    public Reservation getRestSeats(@RequestBody Reservation reservation) {

        return rsvService.getRestSeats(reservation);
    }

    //생성 //일단 int를 void로 바꿈
    @PostMapping("/finish")
    public void createBooking(@RequestParam("seatNumber") String seatNumber) {
         rsvService.createBooking(seatNumber);
    }

    //예약 후 좌석 업데이트 넣기
    @PutMapping("/finish")
    public void updateRestSeats(@RequestParam SeatNowRequest seatNowRequest) {

         rsvService.updateRestSeats(seatNowRequest);
    }

    //삭제
    @DeleteMapping("/delete")
    public void deleteSeat(@PathVariable("seatId") Integer seatNumber) {
        rsvService.remove(seatNumber);
    } 4/26까지 한부분 일단 보류*/



    /*
    @GetMapping("/getReservation")
    public ResponseEntity<List<Search_Reservation>> getReservation(@Param("Search_Reservation") Search_Reservation sr) throws Exception{

        return new ResponseEntity<List<Search_Reservation>>(theaterService.getReservation(sr),HttpStatus.OK);
    }*/
    /*
    @GetMapping("/seat")
    public Reservation restSeat (@RequestBody Reservation reservation) {
        log.info("restSeat()");

        return RsvService.seatInsert(reservation);


    }*/



