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


        @GetMapping("/{basketNo}")
        public BasketBoard BasketBoardRead (
                @PathVariable("basketNo") Integer basketNo){
            log.info("BasketBoardRead()");

            return service.read(basketNo);
        }

        @PutMapping("/{basketNo}")
        public BasketBoard BasketBoardModify (
                @PathVariable("basketNo") Integer boardNo,
                @RequestBody BasketBoard basketboard){
            log.info("ProductBoardSModify(): " + basketboard);

            basketboard.setBoardNo(Long.valueOf(boardNo));
            service.modify(basketboard);

            return basketboard;
        }

        @DeleteMapping("/{basketNo}")
        public void BasketBoardRemove (
                @PathVariable("basketNo") Integer basketNo){
            log.info("BasketBoardRemove()");

            service.remove(basketNo);
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


