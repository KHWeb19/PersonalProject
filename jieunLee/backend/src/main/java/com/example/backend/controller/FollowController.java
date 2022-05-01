package com.example.backend.controller;

import com.example.backend.entity.Follow;
import com.example.backend.entity.Likes;
import com.example.backend.service.FollowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/follow")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class FollowController {

    @Autowired
    private FollowService followService;

    @PostMapping("/{loginNo}/{memberNo}")
    public boolean following(@PathVariable("loginNo") Long my, @PathVariable("memberNo") Long your, @Validated @RequestBody Follow follow) {
        log.info("following()");
        return followService.register(my, your, follow);
    }
}
