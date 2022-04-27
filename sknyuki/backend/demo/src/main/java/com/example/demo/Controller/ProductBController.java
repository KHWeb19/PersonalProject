package com.example.demo.Controller;


import com.example.demo.entity.ProductBoardB;
import com.example.demo.service.ProductBoardBService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/ProductBoardB")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class ProductBController {

    @Autowired
    private ProductBoardBService service;


    @PostMapping("/register")
    public ResponseEntity ProductBoardBRegister(@Validated @RequestBody ProductBoardB productboard) {
        log.info("ProductBoardBRegister()");


       service.register(productboard);

      return new ResponseEntity(productboard, HttpStatus.OK);

    }

        @GetMapping("/list")
        public List<ProductBoardB> productBoardBList () {
            log.info("productBoardBList()");

            return service.list();
        }

        @GetMapping("/{boardNo}")
        public ProductBoardB ProductBoardBRead (
                @PathVariable("boardNo") Integer boardNo){
            log.info("ProductBoardBRead()");

            return service.read(boardNo);
        }

        @PutMapping("/{boardNo}")
        public ProductBoardB ProductBoardBModify (
                @PathVariable("boardNo") Integer boardNo,
                @RequestBody ProductBoardB productboard){
            log.info("ProductBoardBModify(): " + productboard);

            productboard.setBoardNo(Long.valueOf(boardNo));
            service.modify(productboard);

            return productboard;
        }

        @DeleteMapping("/{boardNo}")
        public void ProductBoardBRemove (
                @PathVariable("boardNo") Integer boardNo){
            log.info("ProductBoardBRemove()");

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

          List<ProductBoardB> ProductBoardBList = service.userRead(id);

          return new ResponseEntity(ProductBoardBList, HttpStatus.OK);
      }

    }


