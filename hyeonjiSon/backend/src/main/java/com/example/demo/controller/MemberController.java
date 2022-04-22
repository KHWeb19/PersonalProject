package com.example.demo.controller;

import com.example.demo.controller.request.MemberRequest;
import com.example.demo.controller.request.MemberSearchRequest;
import com.example.demo.controller.response.MemberResponse;
import com.example.demo.entity.Member;
import com.example.demo.service.Member.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/jpaMember")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MemberController {

    @Autowired
    private MemberService memberservice;

    @PostMapping("/register")
    public void jpaMemberRegister(@Validated @RequestBody MemberRequest memberRequest) {
        log.info("register request from vue:() " + memberRequest.getId() + ", " +
                (memberRequest.getAuth().equals("사업자") ? "ROLE_BUSINESS" : "ROLE_INDIVIDUAL"));

        memberservice.register(memberRequest);
    }

    @PostMapping("/login")
    public MemberRequest jpaMemberLogin(@RequestBody MemberRequest memberRequest) {
        log.info("login request from vue:() " + memberRequest);

        MemberRequest memberResponse = memberservice.login(memberRequest);

        if (memberResponse != null) {
            log.info("로그인 성공!");
        } else {
            log.info("로그인 실패!");
        }

        return memberResponse;
    }

    @GetMapping("/checkBusiness")
    public List<MemberResponse> checkBusinessMember () {
        log.info("checkBusiness() ===> findBusinessMember!!!");

        List<Member> businessMember = memberservice.findBusiness();
        List<MemberResponse> responses = new ArrayList<>();

        for (Member member : businessMember) {
            responses.add(new MemberResponse(
                    member.getStoreName(), member.getCity(), member.getDong(), member.getAddress()));
        }

        return responses;
    }
/*
    @PostMapping("/search")
    public List<MemberResponse> search (String keyWord) {
        log.info("find Business+findDong Member");

        List<Member> dongMember = memberservice.findDong(keyWord);
        List<MemberResponse> responses = new ArrayList<>();

        for (Member member : dongMember) {
            responses.add(new MemberResponse(
                    member.getStoreName(), member.getCity(), member.getDong(), member.getAddress()));
        }

        return responses;
    }


 */


    @PostMapping("/search")
    public List<Member> search(@RequestBody MemberSearchRequest memberSearchRequest){
        log.info("search()" + memberSearchRequest);
        String keyWord = memberSearchRequest.getKeyWord();
        return memberservice.searchList(keyWord);

    }

/*
       @GetMapping("/{memberNo}")
    public Member jpaMemberRead(
            @PathVariable("memberNo") Long memberNo) {
        log.info("Member information Read()" + memberNo);

        return memberservice.read(memberNo);
    }
*/
}

