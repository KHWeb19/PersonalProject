package com.example.demo.controller.member;

import com.example.demo.controller.request.CartRequest;
import com.example.demo.controller.request.MemberRequest;
import com.example.demo.entity.Cart.Cart;
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
        log.info("MemberRegister()" + memberRequest.getId() + ", " + memberRequest.getPw() + ", " + memberRequest.getName() + ", "+ memberRequest.getAuth());

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

    @PostMapping("/addCart/{memberNo}")
    public  ResponseEntity<Void> addCart(@PathVariable("memberNo")Long memberNo, @Validated @RequestBody CartRequest cartRequest) throws  Exception {
        System.out.println(memberNo);
        cartRequest.setMemberNo(memberNo);
        service.addCart(cartRequest);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/getCartList/{memberNo}")
    public ResponseEntity<List<Cart>> getCartList(@PathVariable("memberNo") Long memberNo) throws  Exception {


        service.getCartList(memberNo);

        return new ResponseEntity<>(service.getCartList(memberNo),HttpStatus.OK);
    }

    @PostMapping("/ModifyProductNum/{memberNo}")
    public ResponseEntity<Void> ModifyProductNum (@PathVariable("memberNo") Long memberNo, @Validated @RequestBody CartRequest cartRequest) throws  Exception {

        cartRequest.setMemberNo(memberNo);

        service.ModifyProductNum(cartRequest);

        return  new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PostMapping("/deleteProduct/{cartId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("cartId")Long cartId) throws  Exception {

        service.deleteProduct(cartId);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
