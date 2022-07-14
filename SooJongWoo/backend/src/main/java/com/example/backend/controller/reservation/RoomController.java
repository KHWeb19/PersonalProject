package com.example.backend.controller.reservation;

import com.example.backend.controller.member.request.UserRequest;
import com.example.backend.controller.reservation.request.DateRequest;
import com.example.backend.controller.reservation.request.RoomRequest;
import com.example.backend.entity.jpa.Room;
import com.example.backend.service.jpa.JpaRoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/room")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class RoomController {

    @Autowired
    private JpaRoomService roomService;

    @PostMapping("/book")
    public ResponseEntity<RoomRequest> booking(@Validated @RequestBody RoomRequest roomRequest) throws Exception {
        log.info("bookDate: " + roomRequest.getReservedDate() + "roomId: " + roomRequest.getRoomId() + "personNum: " + roomRequest.getPersonNum() +
                "bankName: " + roomRequest.getBankName()+ "price: " + roomRequest.getPrice() + "period: " + roomRequest.getPeriod() +
                "guest: " + roomRequest.getUserId() + "roomCnt: " + roomRequest.getRoomCnt());

        Boolean isSuccess = roomService.checkRoom(roomRequest);

        if (isSuccess) {
            log.info("You can reserve");
            roomService.bookRoom(roomRequest);
            return new ResponseEntity<RoomRequest>(roomRequest, HttpStatus.OK);

        } else {
            log.info("You can't reserve");
            return null;
        }
    }


    @GetMapping("/lists")
    public ResponseEntity<List<RoomRequest>> getReservation (@RequestParam("userId") String userId, UserRequest userRequest, Model model) throws Exception {
        List<RoomRequest> roomRequestList = roomService.bookList(userId);
        model.addAttribute("roomRequestList", roomRequestList);
        log.info("getLists(): " + roomService.bookList(userId));
        return new ResponseEntity<>(roomService.bookList(userId), HttpStatus.OK);

    }

    @GetMapping("/{bookNo}")
    public ResponseEntity<Room> read(@PathVariable("bookNo") Long bookNo) throws Exception {
        Room room = roomService.read(bookNo);

        return new ResponseEntity<Room>(room, HttpStatus.OK);
    }

    @DeleteMapping("/{bookNo}")
    public ResponseEntity<Void> remove(@PathVariable("bookNo") Long bookNo) throws Exception {
        roomService.remove(bookNo);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }


    @GetMapping("/already")
    public ResponseEntity<List<RoomRequest>> getRoomId (@RequestParam("reservedDate") String reservedDate, DateRequest dateRequest) throws Exception {

        roomService.changeDate(dateRequest);
        log.info("change? == " + roomService.changeDate(dateRequest));

        roomService.checkIn(roomService.changeDate(dateRequest));

        log.info("checkIn? == " + roomService.checkIn(roomService.changeDate(dateRequest)));


        return new ResponseEntity<>(roomService.checkIn(roomService.changeDate(dateRequest)), HttpStatus.OK);
    }
}
