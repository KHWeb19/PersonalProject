package com.example.demo.controller.personalProject;

import com.example.demo.common.ApiResponse;
import com.example.demo.controller.request.AddToCartDto;
import com.example.demo.controller.request.CartDto;
import com.example.demo.entity.personalProject.Cart;
import com.example.demo.entity.personalProject.Member;
import com.example.demo.repository.personalProject.MemberRepository;
import com.example.demo.service.personalProject.CartService;
import com.example.demo.service.personalProject.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Slf4j
@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private MemberService memberService;

    private HttpSession session;


    // 장바구니 담기
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addToCart(@RequestBody AddToCartDto addToCartDto) throws Exception {
        log.info("add to cart()");

        cartService.addToCart(addToCartDto);

        return new ResponseEntity<>(new ApiResponse(true, "Added to cart"), HttpStatus.CREATED);
    }


    // 장바구니 리스트 가져오기
//    @GetMapping("/list")
//    public ResponseEntity<CartDto> getCartItems(String id) throws Exception {
//        log.info("get cart list()");
//
//        //Object member = session.getAttribute("member");
//
//        Member memberId = memberService.findById(id);
//        AddToCartDto cartMember = new AddToCartDto();
//
//        if(memberId.equals(cartMember.getMemberId())) {
//            Member member = new Member();
//
//            CartDto cartDto = cartService.listCartItems(member);
//            return new ResponseEntity<>(cartDto, HttpStatus.OK);
//        }
//
////        if(member != null){
////            CartDto cartDto = cartService.listCartItems((Member) member);
////            return new ResponseEntity<>(cartDto, HttpStatus.OK);
////        }
//
//        CartDto cartDtoNull = cartService.listCartItems(null);
//        return new ResponseEntity<>(cartDtoNull, HttpStatus.BAD_REQUEST);
//    }

//    @GetMapping("/list")
//    public ResponseEntity<CartDto> getCartItems() throws Exception {
//        log.info("get cart list()");
//
//        //session 값 null이라고 뜸
//        Object member = session.getAttribute("member");
//
//
//        CartDto cartDto = cartService.listCartItems((Member) member);
//
//        return new ResponseEntity<>(cartDto, HttpStatus.OK);
//    }

    @GetMapping("/list/{id}")
    public ResponseEntity<CartDto> getCartItems(@PathVariable("id") String id) throws Exception {
        log.info("get cart list()");

        Member member = memberService.findById(id);

        CartDto cartDto = cartService.listCartItems(member);

        return new ResponseEntity<>(cartDto, HttpStatus.OK);

    }

    // 장바구니 삭제
    @DeleteMapping("/delete/{cartItemId}")
    public ResponseEntity<ApiResponse> deleteCartItem( @PathVariable("cartItemId") Integer itemId) throws Exception {
        log.info("delete cart item()");

        cartService.deleteCartItem(itemId);

        return new ResponseEntity<>(new ApiResponse(true, "Item has been removed"), HttpStatus.OK);
    }
}
