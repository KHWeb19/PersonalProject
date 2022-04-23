package com.example.demo.controller.FoodBoard;

import com.example.demo.service.FoodBoard.FoodBoardLikeService;
import com.example.demo.service.FoodBoard.FoodBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/foodBoard/like")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class FoodBoardLikeController {

    @Autowired
    FoodBoardLikeService service;

    @PostMapping("/{boardNo}")
    public boolean addLike(@RequestBody String member, @PathVariable("boardNo")Long boardNo){
        log.info("addLike()");

        return service.addLike(member,boardNo);
    }

}
