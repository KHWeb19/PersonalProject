package com.example.demo.controller.Member;

import com.example.demo.controller.Member.request.MemberRequest;
import com.example.demo.entity.Member.Member;
import com.example.demo.entity.Member.MemberCart;
import com.example.demo.service.Member.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/member")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MemberController {

    @Autowired
    private MemberService service;

    @GetMapping("/list")
    public List<Member> memberList(){
        log.info("memberList()");

        return service.list();
    }

    @GetMapping("/{memberNo}")
    public Member memberRead(@PathVariable("memberNo") Long memberNo){
        log.info("memberRead()" + memberNo);

        return service.read(memberNo);
    }

    @PostMapping("/register")
    public void MemberRegister(@Validated @RequestBody MemberRequest memberRequest){
        log.info("MemberRegister(): " + memberRequest.getId() + "," +
                memberRequest.getPw() + "," +memberRequest.getName() + "," + memberRequest.getNickName() + "," + memberRequest.getEmail() + "," +
                (memberRequest.getAuth().equals("개인") ? "ROLE_INDIVIDUAL" : "ROLE_MANAGER"));

        service.register(memberRequest);
    }

    @PostMapping("/login")
    public MemberRequest MemberLogin(@RequestBody MemberRequest memberRequest) {
        log.info("MemberLogin(): " + memberRequest);

        MemberRequest memberResponse = service.login(memberRequest);

        if (memberResponse != null){
            log.info("Login Success");
        }else {
            log.info("Login Fail");
        }

        return memberResponse;
    }

    @GetMapping("/checkId/{id}")
    public Boolean checkDuplicateId (@PathVariable("id") String id){
        log.info("checkDuplicateId(): " + id);

        Boolean checkDupId = service.checkDuplicateId(id);

        return checkDupId;
    }

    @GetMapping("/checkNickName/{nickName}")
    public Boolean checkDuplicateNickName (@PathVariable("nickName") String nickName){
        log.info("checkDuplicateNickName(): " + nickName);

        Boolean checkDupNickName = service.checkDuplicateNickName(nickName);

        return checkDupNickName;
    }

    @GetMapping("/checkEmail/{email}")
    public Boolean checkDuplicateEmail (@PathVariable("email") String email){
        log.info("checkDuplicateEmail(): " + email);

        Boolean checkDupEmail = service.checkDuplicateEmail(email);

        return checkDupEmail;
    }


    @PostMapping("/findUserId")
    public List findUserId (@Validated @RequestBody MemberRequest memberRequest){
        log.info("findUserId()"+memberRequest);


        String email = memberRequest.getEmail();

        List result = service.findUserId(email);

        if (result == null){
            return null;
        }

        return result;
    }

    @PostMapping("/idMatchEmail")
    public Boolean idMatchEmail(@Validated @RequestBody MemberRequest memberRequest){
        log.info("idMatchEmail: " + memberRequest.getId() + " , " + memberRequest.getEmail());

        Boolean result = service.idMatchEmail(memberRequest);

        return result;
    }

    @PostMapping("/resetNoLoginPw/{id}")
    public void resetNoLoginPw(@PathVariable("id") String id, @Validated @RequestBody MemberRequest memberRequest) {
        String pw = memberRequest.getPw();

        service.modifyNoLoginPw(id, pw);
    }

    @PostMapping("/resetLoginPw/{memberNo}")
    public void resetLoginPw(@PathVariable("memberNo") Long memberNo, @Validated @RequestBody MemberRequest memberRequest) {
        String pw = memberRequest.getPw();

        service.modifyLoginPw(memberNo, pw);
    }

    @PostMapping("/modifyNick/{memberNo}")
    public MemberRequest modifyNick(@PathVariable("memberNo") Long memberNo, @Validated @RequestBody MemberRequest memberRequest){

        String nickName = memberRequest.getNickName();

        MemberRequest response = service.modifyNickName(memberNo, nickName, memberRequest);
        return response;
    }

    @PostMapping("/modifyEmail/{memberNo}")
    public MemberRequest modifyEmail(@PathVariable("memberNo") Long memberNo, @Validated @RequestBody MemberRequest memberRequest){

        String email = memberRequest.getEmail();

        MemberRequest response = service.modifyEmail(memberNo, email, memberRequest);

        return response;
    }

    @DeleteMapping("/deleteMember/{memberNo}")
    public void deleteMember(@PathVariable("memberNo") Long memberNo){
        service.deleteMember(memberNo);
    }

    @PostMapping("/myCart/register/{memberNo}")
    public void addMyCart(@PathVariable("memberNo") Integer memberNo, @Validated @RequestBody MemberCart memberCart){
        log.info("" +memberCart);

    }
}
