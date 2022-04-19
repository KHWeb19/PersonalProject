package com.example.demo.entity.Cart;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@ToString
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;

    @Column(name = "member")
    private Long memberNo;

    @Column(length = 32, nullable = false)
    private String imageUrl;

    @Column(length = 32, nullable = false)
    private String productName;

    @Column(nullable = false)
    private Long discount;

    @Column(length = 32, nullable = false)
    private Integer productPrice;

    @Column(length = 32, nullable = false)
    private Integer productDiscountPrice;

    @Column(length = 32, nullable = false)
    private String gender;

    @Column(length = 32, nullable = false)
    private String rating;

    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date upDate;

    public Cart(Long cartId, Long memberNo, String imageUrl, String productName, Long discount, Integer productPrice, Integer productDiscountPrice, Integer productNum, String gender, String rating) {
        this.cartId = cartId;
        this.memberNo = memberNo;
        this.imageUrl = imageUrl;
        this.productName = productName;
        this.discount = discount;
        this.productPrice = productPrice;
        this.productDiscountPrice = productDiscountPrice;
        this.gender = gender;
        this.rating = rating;
    }
}
