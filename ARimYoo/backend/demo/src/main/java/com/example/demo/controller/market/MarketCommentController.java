package com.example.demo.controller.market;

import com.example.demo.entity.market.MarketComment;
import com.example.demo.service.market.MarketCommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/board/market")
@CrossOrigin(origins ="http://localhost:8080", allowedHeaders = "*")
public class MarketCommentController {

    @Autowired
    private MarketCommentService service;

    @PostMapping("/{boardNo}/comment/register")
    public void register (@Validated MarketComment marketComment, @PathVariable ("boardNo") Long boardNo
                          ){
        log.info("register" + marketComment);
        service.register(boardNo, marketComment);

    }

    @GetMapping("/{boardNo}/comment/list")
    public List<MarketComment> read (@PathVariable("boardNo") Long boardNo){
        log.info("comment List");
        return service.list(boardNo);
    }

    @DeleteMapping("/comment/{commentId}")
    public void delete (@PathVariable ("commentId") Long commentId , MarketComment marketComment) {
        log.info("Comment remove()");
        service.delete(commentId);
    }

}
