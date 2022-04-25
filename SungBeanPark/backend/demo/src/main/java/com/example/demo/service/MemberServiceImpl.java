package com.example.demo.service;

import com.example.demo.controller.request.CartRequest;
import com.example.demo.controller.request.MemberRequest;
import com.example.demo.controller.response.MemberResponse;
import com.example.demo.entity.Cart.Cart;
import com.example.demo.entity.member.Member;
import com.example.demo.entity.member.MemberAuth;
import com.example.demo.entity.product.Product;
import com.example.demo.repository.MemberAuthRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.cart.CartRepository;
import com.example.demo.repository.product.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Repository
public class MemberServiceImpl implements MemberService {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private MemberAuthRepository memberAuthRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CartRepository cartRepository;


    @Override
    public void register(MemberRequest memberRequest) {

        String encodedPassword = passwordEncoder.encode(memberRequest.getPw());
        memberRequest.setPw(encodedPassword);


        MemberAuth authEntity = new MemberAuth(memberRequest.getAuth());
        Member memberEntity = new Member(
                memberRequest.getUserId(), memberRequest.getPw(),memberRequest.getName());

        memberEntity.addAuth(authEntity);

        memberRepository.save(memberEntity);
    }

    @Override
    public MemberRequest login(MemberRequest memberRequest) {
        Optional<Member> maybeMember = memberRepository.findByUserId(memberRequest.getUserId());

        if(maybeMember.equals(Optional.empty())) {
            log.info("아이디읎당");
            return null;
        }

        Member loginMember = maybeMember.get();

        if(!passwordEncoder.matches(memberRequest.getPw(), loginMember.getPassword())) {
            log.info("헤이 패스워드 노노");
            return null;
        }

        MemberRequest response = new MemberRequest(
                memberRequest.getMemberNo(),memberRequest.getUserId(), memberRequest.getName(), memberRequest.getAuth());
        log.info("info response" + response);
        return response;
    }

    @Override
    public Boolean checkUserIdValidation(String id) {
        Optional<Member> maybeMember = memberRepository.findByUserId(id);

        if(maybeMember.isPresent()) {
            return false;
        }else {
            return true;
        }
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
    public Member modify(Long memberNo, Member member) {

        member.setMemberNo(Long.valueOf(memberNo));
        memberRepository.save(member);

        return member;
    }

    @Override
    public void remove(Long memberNo) {
        memberRepository.deleteById(Long.valueOf(memberNo));
    }

    @Override
    public List<Member> list() {
        return memberRepository.findAll(Sort.by(Sort.Direction.DESC,"memberNo"));
    }


    @Override
    public List<Member> searchName(String keyWord) {
        List<Member> searchResults = memberRepository.findByUserName(keyWord);

        return searchResults;
    }


    @Override
    public void addToCart(CartRequest cartRequest) throws Exception{
        Cart cart = new Cart(cartRequest.getCartId(), cartRequest.getMemberNo(), cartRequest.getProductNum(), cartRequest.getProductPrice(), cartRequest.getProductDiscountPrice(), cartRequest.getImageUrl(), cartRequest.getProductName(), cartRequest.getGender(), cartRequest.getRating());

        cartRepository.save(cart);
    }


    @Override
    public List<Cart> cartList(Long memberNo) throws  Exception {
        return cartRepository.findCartList(memberNo);
    }



}

