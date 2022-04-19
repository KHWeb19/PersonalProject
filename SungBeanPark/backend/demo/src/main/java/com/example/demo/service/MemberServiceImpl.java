package com.example.demo.service;

import com.example.demo.controller.request.CartRequest;
import com.example.demo.controller.request.MemberRequest;
import com.example.demo.entity.Cart.Cart;
import com.example.demo.entity.member.Member;
import com.example.demo.entity.member.MemberAuth;
import com.example.demo.repository.MemberAuthRepository;
import com.example.demo.repository.MemberRepository;
import com.example.demo.repository.cart.CartRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
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
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CartRepository cartRepository;

    @Transactional
    @Override
    public void register(MemberRequest memberRequest) {

        String encodedPassword = passwordEncoder.encode(memberRequest.getPw());
        memberRequest.setPw(encodedPassword);

        Member memberEntity = new Member(
                memberRequest.getId(), memberRequest.getPw(),memberRequest.getName());

        memberRepository.save(memberEntity);

        MemberAuth authEntity = new MemberAuth(memberRequest.getAuth(), memberEntity);

        memberAuthRepository.save(authEntity);
    }

    @Transactional
    @Override
    public MemberRequest login(MemberRequest memberRequest) {
        Optional<Member> maybeMember = memberRepository.findByUserId(memberRequest.getId());

        if(maybeMember.equals(Optional.empty())) {
            log.info("아이디읎당");
            return null;
        }

        Member loginMember = maybeMember.get();

        if(!passwordEncoder.matches(memberRequest.getPw(), loginMember.getPassword())) {
            log.info("헤이 패스워드 노노");
            return null;
        }

        Optional<MemberAuth> maybeMemberAuth =
                memberAuthRepository.findByMemberNo(loginMember.getMemberNo());

        if(maybeMemberAuth == null) {
            log.info("no auth");
            return null;
        }

        MemberAuth memberAuth = maybeMemberAuth.get();

        MemberRequest response = new MemberRequest(
                memberRequest.getId(),
                null,
                memberRequest.getName(),
                memberAuth.getAuth());

        return response;
    }

    @Transactional
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
    public void addCart(CartRequest cartRequest) throws Exception {
        Cart cart = new Cart(cartRequest.getMemberNo(), cartRequest.getCartId(), cartRequest.getImageUrl(), cartRequest.getProductName(),
                cartRequest.getDiscount(), cartRequest.getProductPrice(), cartRequest.getProductDiscountPrice(), cartRequest.getProductNum(),
                cartRequest.getGender(), cartRequest.getRating());

        cartRepository.save(cart);
    }

    @Override
    public List<Cart> getCartList(Long memberNo) throws Exception {
        return cartRepository.findCartList(memberNo);
    }

    @Override
    public void ModifyProductNum(CartRequest cartRequest) {
        Cart cart = new Cart(cartRequest.getMemberNo(), cartRequest.getCartId(), cartRequest.getImageUrl(), cartRequest.getProductName(),
                cartRequest.getDiscount(), cartRequest.getProductPrice(), cartRequest.getProductDiscountPrice(), cartRequest.getProductNum(),
                cartRequest.getGender(), cartRequest.getRating());
        cartRepository.save(cart);
    }

    @Override
    public void deleteProduct(Long memberNo) throws Exception {
        cartRepository.deleteById(memberNo);
    }
}
