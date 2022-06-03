package com.example.demo.controller.jpa.Complaint;

import com.example.demo.entity.jpa.Complaint.ComplaintBoard;
import com.example.demo.service.jpa.Complaint.ComplaintBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/complaintboard")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class ComplaintBoardController {

    @Autowired
    private ComplaintBoardService service;

    @PostMapping("/register")
    public void complaintBoardRegister (@Validated @RequestBody ComplaintBoard board) {
        log.info("complaintBoardRegister()");

        service.register(board);
    }

    @GetMapping("/list")
    public List<ComplaintBoard> complaintBoardList () {
        log.info("complaintBoardList()");

        return service.list();
    }

    @GetMapping("/{boardNo}")
    public ComplaintBoard complaintBoardRead (
            @PathVariable("boardNo") Integer boardNo) {
        log.info("complaintBoardRead()");

        return service.read(boardNo);
    }

    @PutMapping("/{boardNo}")
    public ComplaintBoard complaintBoardModify (
            @PathVariable("boardNo") Integer boardNo,
            @RequestBody ComplaintBoard complaintBoard) {
        log.info("complaintBoardModify(): " + complaintBoard);

        complaintBoard.setBoardNo(Long.valueOf(boardNo));
        service.modify(complaintBoard);

        return complaintBoard;
    }

    @DeleteMapping("/{boardNo}")
    public void complaintBoardRemove (
            @PathVariable("boardNo") Integer boardNo) {
        log.info("complaintBoardRemove()");

        service.remove(boardNo);
    }
}