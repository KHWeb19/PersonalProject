package com.example.demo.Controller;

import com.example.demo.entity.BrandCheckBoard;
import com.example.demo.service.BrandCheckBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/BrandCheckBoard")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class BrandCheckController {

    @Autowired
    private BrandCheckBoardService service;

    @PostMapping("/register")
    public void BrandCheckBoardRegister(@Validated @RequestBody BrandCheckBoard checkboard) {
        log.info("BrandCheckBoardRegister()");

       service.register(checkboard);
    }

        @GetMapping("/list")
        public List<BrandCheckBoard> CheckBrandBoardList () {
            log.info("CheckBrandBoardList()");

            return service.list();
        }

        @GetMapping("/{boardNo}")
        public BrandCheckBoard BrandCheckBoardRead (
                @PathVariable("boardNo") Integer boardNo){
            log.info("BrandCheckBoardRead()");

            return service.read(boardNo);
        }

        @PutMapping("/{boardNo}")
        public BrandCheckBoard BrandCheckBoardModify (
                @PathVariable("boardNo") Integer boardNo,
                @RequestBody BrandCheckBoard checkBoard){
            log.info("CheckBrandBoardModify(): " + checkBoard);

            checkBoard.setBoardNo(Long.valueOf(boardNo));
            service.modify(checkBoard);

            return checkBoard;
        }

        @DeleteMapping("/{boardNo}")
        public void BrandCheckBoardRemove (
                @PathVariable("boardNo") Integer boardNo){
            log.info("BrandCheckBoardRemove()");

            service.remove(boardNo);
        }
    }


