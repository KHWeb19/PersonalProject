package com.example.demo.service.Member;

import com.example.demo.controller.Member.request.MemberCartRequest;
import com.example.demo.controller.Member.request.MemberRequest;
import com.example.demo.entity.FoodBoard.FoodBoard;
import com.example.demo.entity.Member.Member;
import com.example.demo.entity.Member.MemberAuth;
import com.example.demo.entity.Member.MemberCart;
import com.example.demo.repository.FoodBoard.FoodBoardRepository;
import com.example.demo.repository.Member.MemberAuthRepository;
import com.example.demo.repository.Member.MemberCartRepository;
import com.example.demo.repository.Member.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private MemberAuthRepository memberAuthRepository;

    @Autowired
    private MemberCartRepository memberCartRepository;

    @Autowired
    private FoodBoardRepository foodBoardRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Member> list() {
        return memberRepository.findAll(Sort.by(Sort.Direction.DESC, "memberNo"));
    }

    @Override
    public Member read(Long memberNo) {
        Optional<Member> maybeReadMember = memberRepository.findById(Long.valueOf(memberNo));


        if (maybeReadMember.equals(Optional.empty())){

            return null;
        }
        log.info("info " + maybeReadMember);
        return maybeReadMember.get();
    }

    @Override
    public void register(MemberRequest memberRequest) {
        String encodedPassword = passwordEncoder.encode(memberRequest.getPw());
        memberRequest.setPw(encodedPassword);

        MemberAuth authEntity = new MemberAuth(memberRequest.getAuth());
        Member memberEntity = new Member(memberRequest.getId(), memberRequest.getPw(), memberRequest.getName() ,memberRequest.getNickName(),
                memberRequest.getEmail());

        memberEntity.addAuth(authEntity);

        memberRepository.save(memberEntity);

    }

    @Override
    public MemberRequest login(MemberRequest memberRequest) {
        Optional<Member> maybeMember = memberRepository.findByUserId(memberRequest.getId());

        if (maybeMember.equals(Optional.empty())){
            log.info("No Id");
            return null;
        }

        Member loginMember = maybeMember.get();

        if (!passwordEncoder.matches(memberRequest.getPw(), loginMember.getPw())) {
            log.info("Wrong Pw");
            return null;
        }

        if (loginMember.getId().equals(memberRequest.getId())){
            memberRequest.setMemberNo(loginMember.getMemberNo());
            memberRequest.setName(loginMember.getName());
            memberRequest.setNickName(loginMember.getNickName());
            memberRequest.setEmail(loginMember.getEmail());
        }

        MemberRequest response = new MemberRequest(
                memberRequest.getMemberNo(),memberRequest.getId(),null,memberRequest.getName() ,memberRequest.getNickName(),memberRequest.getEmail(),memberRequest.getAuth());
        log.info("info response" + response);
        return response;
    }

    @Override
    public Boolean checkDuplicateId(String id) {
        Optional<Member> checkDupId = memberRepository.findByUserId(id);

        if (checkDupId.isPresent()){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public Boolean checkDuplicateNickName(String nickName) {
        Optional<Member> checkDupNickName = memberRepository.findByUserNickName(nickName);

        if (checkDupNickName.isPresent()){
            return false;
        }else {
            return true;
        }
    }

    @Override
    public Boolean checkDuplicateEmail(String email) {
        Optional<Member> checkDupEmail = memberRepository.findByUserEmail(email);

        if (checkDupEmail.isPresent()){
            return false;
        }else {
            return true;
        }
    }



    @Override
    public List findUserId(String email) {

        return memberRepository.searchUserId(email);
    }

    @Override
    public Boolean idMatchEmail(MemberRequest memberRequest) {
        Optional<Member> maybeMember = memberRepository.findByUserId(memberRequest.getId());
        if (!maybeMember.isPresent()){
            return false;
        }
        Member DbMember = maybeMember.get();

        String UserEmail = DbMember.getEmail();

        String MaybeEmail = memberRequest.getEmail();

        if (UserEmail.equals(MaybeEmail)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void modifyNoLoginPw(String id, String pw) {
        String encodedPassword = passwordEncoder.encode(pw);
        memberRepository.modifyNoLoginPw(id, encodedPassword);
    }

    @Override
    public void modifyLoginPw(Long memberNo, String pw) {
        String encodedPassword = passwordEncoder.encode(pw);
        memberRepository.modifyLoginPw(memberNo, encodedPassword);
    }

    @Override
    public MemberRequest modifyNickName(Long memberNo, String nickName, MemberRequest memberRequest) {
        memberRepository.modifyNickName(memberNo, nickName);

        Optional<Member> maybeMember = memberRepository.findById(Long.valueOf(memberNo));


        Member loginMember = maybeMember.get();

        memberRequest.setId(loginMember.getId());
        memberRequest.setMemberNo(loginMember.getMemberNo());
        memberRequest.setName(loginMember.getName());
        memberRequest.setNickName(loginMember.getNickName());
        memberRequest.setEmail(loginMember.getEmail());


        MemberRequest response = new MemberRequest(
                memberRequest.getMemberNo(),memberRequest.getId(),null,memberRequest.getName() ,memberRequest.getNickName(),memberRequest.getEmail(),memberRequest.getAuth());
        log.info("info response" + response);

        return response;
    }

    @Override
    public MemberRequest modifyEmail(Long memberNo, String email,MemberRequest memberRequest) {
        memberRepository.modifyEmail(memberNo, email);

        Optional<Member> maybeMember = memberRepository.findById(Long.valueOf(memberNo));

        Member loginMember = maybeMember.get();

        memberRequest.setId(loginMember.getId());
        memberRequest.setMemberNo(loginMember.getMemberNo());
        memberRequest.setName(loginMember.getName());
        memberRequest.setNickName(loginMember.getNickName());
        memberRequest.setEmail(loginMember.getEmail());

        MemberRequest response = new MemberRequest(
                memberRequest.getMemberNo(),memberRequest.getId(),null,memberRequest.getName() ,memberRequest.getNickName(),memberRequest.getEmail(),memberRequest.getAuth());
        log.info("info response" + response);

        return response;
    }

    @Override
    public void deleteMember(Long memberNo) {
        memberRepository.deleteById(memberNo);
    }

    @Override
    public boolean addMyFood(MemberCartRequest memberCartRequest) {

        if (memberCartRepository.findBoardNoByMemberNoAndBoardNo(memberCartRequest.getMemberNo(),memberCartRequest.getBoardNo()).isEmpty()){
            MemberCart memberCart = new MemberCart(memberCartRequest.getCartNo(), memberCartRequest.getMemberNo(),memberCartRequest.getBoardNo(),memberCartRequest.getName(),memberCartRequest.getWriter(),memberCartRequest.getDes(),memberCartRequest.getKind(),memberCartRequest.getMat(),memberCartRequest.getWay(),memberCartRequest.getFilename(),memberCartRequest.getFilepath());

            memberCartRepository.save(memberCart);

            return true;
        }
        return false;

        /*
        Optional<FoodBoard> maybeFood = foodBoardRepository.findById(boardNo);

        FoodBoard cartFood = maybeFood.get();


        if (!memberCartRepository.findBoardNoByMemberNoAndBoardNo(memberNo,boardNo).isEmpty()){

        }


        log.info(""+cartFood);

        MemberCart memberCart = new MemberCart();
        memberCart.setBoardNo(cartFood.getBoardNo());
        memberCart.setMemberNo(memberNo);
        memberCart.setName(cartFood.getName());
        memberCart.setWriter(cartFood.getWriter());
        memberCart.setDes(cartFood.getDes());
        memberCart.setKind(cartFood.getKind());
        memberCart.setWay(cartFood.getWay());
        memberCart.setMat(cartFood.getMat());
        memberCart.setFilename(cartFood.getFilename());
        memberCart.setFilepath(cartFood.getFilepath());
        memberCart.setRegDate(cartFood.getRegDate());
        memberCart.setCommentCnt(cartFood.getCommentCnt());
        memberCart.setLikeCnt(cartFood.getLikeCnt());

        memberCartRepository.save(memberCart);
    */


    }


}
