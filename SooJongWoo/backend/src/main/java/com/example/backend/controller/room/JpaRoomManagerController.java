package com.example.backend.controller.room;

import com.example.backend.entity.jpa.Reservation;
import com.example.backend.entity.jpa.Room;
import com.example.backend.service.jpa.JpaRoomManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/roomManage")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class JpaRoomManagerController {

    @Autowired
    private JpaRoomManagerService roomManagerService;


    @GetMapping("/lists")
    public ResponseEntity<List<Room>> getLists () throws Exception {
        log.info("getLists(): " + roomManagerService.list());

        return new ResponseEntity<>(roomManagerService.list(), HttpStatus.OK);
    }

    @GetMapping("/reservationLists")
    public ResponseEntity<List<Reservation>> getReservationLists () throws Exception {
        log.info("getReservationLists(): " + roomManagerService.bookList());

        return new ResponseEntity<>(roomManagerService.bookList(), HttpStatus.OK);
    }

    @GetMapping("/{bookNo}")
    public ResponseEntity<Room> read(@PathVariable("bookNo") Long bookNo) throws Exception {
        Room room = roomManagerService.read(bookNo);

        return new ResponseEntity<Room>(room, HttpStatus.OK);
    }


    @DeleteMapping("/{bookNo}")
    public ResponseEntity<Void> remove(@PathVariable("bookNo") Long bookNo) throws Exception {
        roomManagerService.remove(bookNo);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }


}
