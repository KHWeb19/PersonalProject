package com.example.demo.Controller;


import com.example.demo.entity.BasketBoard;
import com.example.demo.service.BasketBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/BasketBoard")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class BasketController {

    @Autowired
    private BasketBoardService service;


    @PostMapping("/register")
    public ResponseEntity BasketBoardRegister(@Validated @RequestBody BasketBoard basketboard) {
        log.info("BasketBoardRegister()");


       service.register(basketboard);

      return new ResponseEntity(basketboard, HttpStatus.OK);

    }


        @GetMapping("/{boardNo}")
        public BasketBoard BasketBoardRead (
                @PathVariable("boardNo") Integer boardNo){
            log.info("BasketBoardRead()");

            return service.read(boardNo);
        }

        @PutMapping("/{boardNo}")
        public BasketBoard BasketBoardModify (
                @PathVariable("boardNo") Integer boardNo,
                @RequestBody BasketBoard basketboard){
            log.info("ProductBoardSModify(): " + basketboard);

            basketboard.setBoardNo(Long.valueOf(boardNo));
            service.modify(basketboard);

            return basketboard;
        }

        @DeleteMapping("/{boardNo}")
        public void BasketBoardRemove (
                @PathVariable("boardNo") Integer boardNo){
            log.info("BasketBoardRemove()");

            service.remove(boardNo);
        }

      /*  @GetMapping("/userRead/{id}")
        public List<BrandCheckBoard> CheckBrandBoardList (
                @PathVariable("id") String id) {
            log.info("MyPageCheckBrandList()");

            return service.userRead(id);
        }*/
      @GetMapping("/userRead/{id}")
      public ResponseEntity userRead(@PathVariable("id") String id) throws Exception {
          log.info("Recommend UserRead");

          List<BasketBoard> BasketBoardList = service.userRead(id);

          return new ResponseEntity(BasketBoardList, HttpStatus.OK);
      }

    }


