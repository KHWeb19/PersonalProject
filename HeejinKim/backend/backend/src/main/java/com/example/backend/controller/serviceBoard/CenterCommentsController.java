package com.example.backend.controller.serviceBoard;

import com.example.backend.controller.board.request.CommentRequest;
import com.example.backend.entity.BoardComments;
import com.example.backend.entity.CenterComments;
import com.example.backend.service.board.BoardCommentsService;
import com.example.backend.service.serviceCenter.CenterCommentsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/centerComments")
@CrossOrigin(origins ="http://localhost:8080", allowedHeaders = "*")
public class CenterCommentsController {

    @Autowired
    private CenterCommentsService service;

    @PostMapping("/register/{centerNo}")
    public void serviceCommentsRegister ( @PathVariable("centerNo") Integer centerNo,
                                        @Validated @RequestBody CenterCommentRequest centerCommentRequest) {

        log.info("serviceCommentsRegister()" + centerCommentRequest);

        service.register(centerNo, centerCommentRequest);
    }


    @GetMapping("/list/{centerNo}")
    public List<CenterComments> serviceCommentsList (@PathVariable("centerNo") Integer centerNo) {
        log.info("serviceCommentsList()");

        return service.list(centerNo);
    }


    @PutMapping("/{comNo}")
    public CenterComments boardCommentsModify (
            @PathVariable("comNo") Integer comNo,
            @Validated @RequestBody CenterCommentRequest centerCommentRequest) {
        log.info("boardCommentModify(): " + centerCommentRequest);


        return service.modify(comNo, centerCommentRequest);

    }



    @DeleteMapping("/{comNo}")
    public void centerCommentsRemove (
            @PathVariable("comNo") Integer comNo,CenterComments centerComments) {
        log.info("commentRemove()");

        service.remove(comNo);
    }

}
