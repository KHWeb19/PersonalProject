package com.example.demo.controller;

import com.example.demo.request.search.ChangePwRequest;
import com.example.demo.request.search.SearchIdRequest;
import com.example.demo.request.search.SearchPwRequest;
import com.example.demo.response.search.SearchIdResponse;
import com.example.demo.service.search.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/search")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class SearchMemberController {

    @Autowired
    private SearchService searchService;

    @PutMapping("/id")
    public SearchIdResponse SearchId(@Validated @RequestBody SearchIdRequest searchIdRequest){

        log.info("searchId() :" +searchIdRequest);

        return searchService.searchId(searchIdRequest);
    }

    @PutMapping("/pw")
    public Boolean searchPw(@Validated @RequestBody SearchPwRequest searchPwRequest){
        log.info("searchPw() : "+ searchPwRequest.getId() + ", " + searchPwRequest.getName());

        return searchService.searchPw(searchPwRequest);
    }

    @PutMapping("/changePw")
    public void changePw(@Validated @RequestBody ChangePwRequest changePwRequest){
        log.info("searchPw() : "+ changePwRequest.getPw());

        searchService.changePw(changePwRequest);
    }
}
