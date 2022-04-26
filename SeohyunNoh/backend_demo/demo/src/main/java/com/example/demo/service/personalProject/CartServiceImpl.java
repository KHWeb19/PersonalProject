package com.example.demo.service.personalProject;

import com.example.demo.controller.request.AddToCartDto;
import com.example.demo.controller.request.CartDto;
import com.example.demo.controller.request.CartItemDto;
import com.example.demo.entity.personalProject.Cart;
import com.example.demo.entity.personalProject.Member;
import com.example.demo.entity.personalProject.Product;
import com.example.demo.repository.personalProject.CartRepository;
import com.example.demo.repository.personalProject.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private ProductService productService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    private HttpSession session;

    @Autowired
    private CartRepository cartRepository;

    @Override
    public void addToCart(AddToCartDto addToCartDto) throws Exception {

        // member id가 유효한지 체크
        Member memberCheck = memberService.findById(addToCartDto.getMemberId());

        // product id가 유효한지 체크
        Product product = productService.findById(addToCartDto.getProductId());

        Cart cart = new Cart();
        cart.setProduct(product);
        cart.setMember(memberCheck);
        cart.setQuantity(addToCartDto.getQuantity());
        cart.setCreatedDate(new Date());

        cartRepository.save(cart);
    }

    @Override
    public CartDto listCartItems(Member member) throws Exception {
        List<Cart> cartList = cartRepository.findAllByMemberOrderByCreatedDateDesc(member);

        List<CartItemDto> cartItems = new ArrayList<>();
        double totalCost = 0;
        for (Cart cart: cartList) {
            CartItemDto cartItemDto = new CartItemDto(cart);
            totalCost += cartItemDto.getQuantity() * cart.getProduct().getPrice();
            cartItems.add(cartItemDto);
        }

        CartDto cartDto = new CartDto();

        cartDto.setTotalCost(totalCost);
        cartDto.setCartItems(cartItems);

        return  cartDto;
    }

    @Override
    public void deleteCartItem(Integer cartItemId, Member member) {

    }
}
