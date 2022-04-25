package com.example.demo.controller.member;

import com.example.demo.controller.request.CartRequest;
import com.example.demo.controller.request.MemberRequest;
import com.example.demo.controller.request.MemberSearchRequest;
import com.example.demo.entity.Cart.Cart;
import com.example.demo.entity.member.Member;
import com.example.demo.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/Member")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders ="*")
public class MemberController {

    @Autowired
    private MemberService service;

    @PostMapping("/register")
    public void registerMember(@Validated @RequestBody MemberRequest memberRequest) {
        log.info("MemberRegister()" + memberRequest.getUserId() + ", " + memberRequest.getPw() + ", " + memberRequest.getName() + ", "+ memberRequest.getAuth());

        service.register(memberRequest);
    }

    @PostMapping("/login")
    public MemberRequest memberLogin (@RequestBody MemberRequest memberRequest) {
        log.info("MemberLogin()" + memberRequest);

        MemberRequest memberResponse = service.login(memberRequest);

        if(memberResponse != null) {
            log.info("성공좀!");
        }else{
            log.info("그만실패좀!");
        }

        return memberResponse;
    }
    @GetMapping("/check/{id}")
    public Boolean findId (@PathVariable("id") String id) {
        log.info("findId()" + id);

        Boolean maybeMember = service.checkUserIdValidation(id);

        return maybeMember;
    }

    @GetMapping("/{memberNo}")
    public Member read (
            @PathVariable("memberNo") Long memberNo) {
        log.info("read()" + memberNo);

        return service.read(memberNo);
    }

    @PutMapping("/modify/{memberNo}")
    public Member memberModify(@PathVariable("memberNo") Long memberNo,
                                       @RequestBody Member member) {
        log.info("memberModify :");

        return service.modify(memberNo, member);
    }

    @DeleteMapping("/{memberNo}")
    public void memberRemove (
            @PathVariable("memberNo") Long memberNo) {
        log.info("memberRemove()");

        service.remove(memberNo);
    }

    @GetMapping("/list")
    public List<Member> memberList () {
        log.info("memberList()");

        return service.list();
    }

    @PostMapping("/search")
    public List<Member> search(@RequestBody MemberSearchRequest memberSearchRequest){
        log.info("search()" + memberSearchRequest);
        String keyWord = memberSearchRequest.getKeyWord();
        return service.searchName(keyWord);

    }

    @PostMapping("/addToCart/{memberNo}")
    public ResponseEntity<Void> addToCart(@PathVariable("memberNo")Long memberNo, @Validated @RequestBody CartRequest cartRequest) throws  Exception {
        System.out.println(memberNo);
        cartRequest.setMemberNo(memberNo);
        service.addToCart(cartRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/addToCart/list/{memberNo}")
    public ResponseEntity<List<Cart>> cartList(@PathVariable("memberNo") Long memberNo) throws  Exception {

        service.cartList(memberNo);

        return new ResponseEntity<>(service.cartList(memberNo),HttpStatus.OK);
    }

}
