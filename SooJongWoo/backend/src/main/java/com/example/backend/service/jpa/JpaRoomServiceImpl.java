package com.example.backend.service.jpa;

import com.example.backend.controller.reservation.request.DateRequest;
import com.example.backend.controller.reservation.request.RoomRequest;
import com.example.backend.entity.jpa.Reservation;
import com.example.backend.entity.jpa.Room;
import com.example.backend.repository.jpa.JpaReservationRepository;
import com.example.backend.repository.jpa.JpaRoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class JpaRoomServiceImpl implements JpaRoomService {

    @Autowired
    private JpaRoomRepository roomRepository;

    @Autowired
    private JpaReservationRepository reservationRepository;

    @Override
    public void bookRoom(RoomRequest roomRequest) throws Exception {

        Reservation bookEntity = new Reservation(roomRequest.getReservedDate());
        Room roomEntity = new Room(roomRequest.getRoomId(), roomRequest.getPeriod(), roomRequest.getPersonNum(),
                roomRequest.getBankName(), roomRequest.getPrice(), roomRequest.getUserId(), roomRequest.getRoomCnt(), roomRequest.getRegDate());
        roomEntity.addDate(bookEntity);

        roomRepository.save(roomEntity);
    }


    @Override
    public boolean checkRoom(RoomRequest roomRequest) throws Exception {
        List<Room> already = roomRepository.findByRoomId(roomRequest.getRoomId());
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date inputDate = roomRequest.getReservedDate();

        String comeDate = "";
        comeDate = format.format(inputDate);
        Date reserveDate = format.parse(comeDate);

        List<Reservation> bookDate = reservationRepository.findByDate(roomRequest.getReservedDate());


        if (already.isEmpty()) {
            log.info("room is empty : " + roomRepository.findByRoomId(roomRequest.getRoomId()));
            return true;
        }


        if(!already.isEmpty()) {
            for(Room room : already) {
                if(room.getRoomId().equals(roomRequest.getRoomId()))
                    for(Reservation reservation : bookDate) {
                        if(room.getBookNo().equals(reservation.getBookNo())){
                            log.info("same bookNo :" + room.getBookNo() + reservation.getBookNo());
                            if(room.getRoomId().equals(roomRequest.getRoomId())) {
                                Date inDate = reservation.getReservedDate();
                                String savedDate = "";
                                savedDate = format.format(inDate);
                                log.info("same room :" + room.getRoomId() + roomRequest.getRoomId());
                                if(savedDate.equals(comeDate)) {
                                    log.info("same date :" + savedDate + comeDate);
                                    return false;
                                }
                            }
                        }
                    }
            }
        }
        return true;
    }



    // 수정 후 여러 내역을 볼 수있음
    @Override
    public List<RoomRequest> bookList(String userId) throws Exception {
        List<Room> rooms =  roomRepository.findByUserIdContaining(userId);
        List<RoomRequest> roomsList = new ArrayList<>();

        if(rooms.isEmpty()) return roomsList;

        for(Room room : rooms) {
            roomsList.add(this.convertEntityToRequest(room));
        }

        return roomsList;
    }

    private RoomRequest convertEntityToRequest(Room room) {
        for (Reservation reservation : room.getDateList()) {
            Date date = reservation.getReservedDate();

            return RoomRequest.builder()
                    .bookNo(room.getBookNo())
                    .reservedDate(date)
                    .personNum(room.getPersonNum())
                    .bankName(room.getBankName())
                    .roomId(room.getRoomId())
                    .price(room.getPrice())
                    .regDate(room.getRegDate())
                    .build();
        }
        return null;
    }

    @Override
    public Room read(Long bookNo) throws Exception {
        Optional<Room> bookDetail = roomRepository.findById(bookNo);
        if(bookDetail.isPresent()) {
            Room room = bookDetail.get();
            roomRepository.save(room);

            return room;
        } else {
            throw new NullPointerException();
        }

    }

    @Override
    public void remove(Long bookNo) throws Exception {
        roomRepository.deleteById(bookNo);
    }

    // string -> date
    public Date changeDate(DateRequest dateRequest) throws Exception {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date inputDate = format.parse(dateRequest.getReservedDate());
        log.info("reservedDate = " + inputDate);


        return inputDate;
    }


    // 캘린더 체크
    @Override
    public List<RoomRequest> checkIn(Date reservedDate) throws Exception {

        List<Reservation> checkDate = reservationRepository.findByDate(reservedDate);
        List<RoomRequest> checkList = new ArrayList<>();

        for (Reservation reservation : checkDate) {
            List<Room> matchRoomId = roomRepository.findByBookNo(reservation.getBookNo());
            for (Room room : matchRoomId) {
                log.info("======roomId : " + room.getRoomId());
                checkList.add(convertEntityToCheckIn(room));
            }

        }
        return checkList;
    }

    private RoomRequest convertEntityToCheckIn(Room room) {
        return RoomRequest.builder()
                .bookNo(room.getBookNo())
                .roomId(room.getRoomId())
                .build();
    }

}
