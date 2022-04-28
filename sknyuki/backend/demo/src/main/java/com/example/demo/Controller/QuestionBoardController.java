package com.example.demo.Controller;


import com.example.demo.entity.BrandCheckBoard;
import com.example.demo.entity.QuestionBoard;
import com.example.demo.service.QuestionBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/QuestionBoard")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class QuestionBoardController {

    @Autowired
    private QuestionBoardService service;


    @PostMapping("/register")
    public ResponseEntity QuestionBoardRegister(@Validated @RequestBody QuestionBoard questionboard) {
        log.info("QuestionBoardRegister()");


       service.register(questionboard);

      return new ResponseEntity(questionboard, HttpStatus.OK);

    }

        @GetMapping("/list")
        public List<QuestionBoard> QuestionBoardList () {
            log.info("QuestionBoardList()");

            return service.list();
        }

        @GetMapping("/{boardNo}")
        public QuestionBoard QuestionBoardRead (
                @PathVariable("boardNo") Integer boardNo){
            log.info("QuestionBoardRead()");

            return service.read(boardNo);
        }

        @PutMapping("/{boardNo}")
        public QuestionBoard QuestionBoardModify (
                @PathVariable("boardNo") Integer boardNo,
                @RequestBody QuestionBoard questionBoard){
            log.info("QuestionBoardModify(): " + questionBoard);

            questionBoard.setBoardNo(Long.valueOf(boardNo));
            service.modify(questionBoard);

            return questionBoard;
        }

        @DeleteMapping("/{boardNo}")
        public void QuestionBoardRemove (
                @PathVariable("boardNo") Integer boardNo){
            log.info("QuestionBoardRemove()");

            service.remove(boardNo);
        }

    @GetMapping("/userRead/{id}")
    public ResponseEntity userRead(@PathVariable("id") String id) throws Exception {
        log.info("Recommend UserRead");

        List<QuestionBoard> QuestionBoardList = service.userRead(id);

        return new ResponseEntity(QuestionBoardList, HttpStatus.OK);
    }
    }


