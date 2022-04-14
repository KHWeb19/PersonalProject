package com.example.demo.controller.FoodBoard;

import com.example.demo.entity.FoodBoard.FoodBoard;
import com.example.demo.service.FoodBoard.FoodBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/foodBoard")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class FoodBoardController {

    @Autowired
    private FoodBoardService service;

    @PostMapping("/register")
    public void foodBoardRegister(@Validated FoodBoard foodBoard, @RequestParam(required = false)MultipartFile file) throws Exception {
        log.info("foodBoardRegister()" + file);

        service.register(foodBoard, file);
    }

    @GetMapping("/list")
    public List<FoodBoard> foodBoardList(){
        log.info("foodBoardList()");

        return service.list();
    }

    @GetMapping("getFoodList")
    public List<FoodBoard> getFoodList(){
        log.info("getFoodList()");
        return service.getFoodList();
    }

    @GetMapping("/{boardNo}")
    public FoodBoard foodBoardRead(
            @PathVariable("boardNo") Integer boardNo){
        log.info("foodBoardRead()" +boardNo);

        return service.read(boardNo);
    }

    @PutMapping("/{boardNo}")
    public FoodBoard foodBoardModify(
            @PathVariable("boardNo") Integer boardNo,  FoodBoard foodBoard ,@RequestParam(required = false) MultipartFile file) throws Exception {
        log.info("foodBoardModify() " +boardNo + ""+ foodBoard.getFilename());

        foodBoard.setBoardNo(Long.valueOf(boardNo));
        service.modify(foodBoard,file);

        return foodBoard;
    }

    @DeleteMapping("/{boardNo}")
    public void foodBoardRemove(
            @PathVariable("boardNo") Integer boardNo,FoodBoard foodBoard) throws Exception {
        log.info("foodBoardRemove()" +boardNo);

        service.remove(boardNo);
    }
}
