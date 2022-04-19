package com.example.demo.entity.product;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(length = 32, nullable = false)
    private String imageUrl;

    @Column(length = 32, nullable = false)
    private String productName;

    @Column(length = 32, nullable = false)
    private String productNum;

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


    public Product(Long productId, String imageUrl, String productName, String productNum,Long discount, Integer productPrice, Integer productDiscountPrice, String gender, String rating) {
        this.productId = productId;
        this.imageUrl = imageUrl;
        this.productName = productName;
        this.discount = discount;
        this.productPrice = productPrice;
        this.productDiscountPrice = productDiscountPrice;
        this.gender = gender;
        this.rating = rating;
        this.productNum = productNum;
    }
}
