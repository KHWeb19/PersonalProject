package com.example.demo.Controller;


import com.example.demo.entity.ProductBoardS;
import com.example.demo.service.ProductBoardSService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/ProductBoardS")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class ProductSController {

    @Autowired
    private ProductBoardSService service;


    @PostMapping("/register")
    public ResponseEntity ProductBoardSRegister(@Validated @RequestBody ProductBoardS productboard) {
        log.info("ProductBoardSRegister()");


       service.register(productboard);

      return new ResponseEntity(productboard, HttpStatus.OK);

    }

        @GetMapping("/list")
        public List<ProductBoardS> productBoardSList () {
            log.info("productBoardSList()");

            return service.list();
        }

        @GetMapping("/{boardNo}")
        public ProductBoardS ProductBoardSRead (
                @PathVariable("boardNo") Integer boardNo){
            log.info("ProductBoardSRead()");

            return service.read(boardNo);
        }

        @PutMapping("/{boardNo}")
        public ProductBoardS ProductBoardSModify (
                @PathVariable("boardNo") Integer boardNo,
                @RequestBody ProductBoardS productboard){
            log.info("ProductBoardSModify(): " + productboard);

            productboard.setBoardNo(Long.valueOf(boardNo));
            service.modify(productboard);

            return productboard;
        }

        @DeleteMapping("/{boardNo}")
        public void ProductBoardSRemove (
                @PathVariable("boardNo") Integer boardNo){
            log.info("ProductBoardSRemove()");

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

          List<ProductBoardS> ProductBoardSList = service.userRead(id);

          return new ResponseEntity(ProductBoardSList, HttpStatus.OK);
      }

    }


