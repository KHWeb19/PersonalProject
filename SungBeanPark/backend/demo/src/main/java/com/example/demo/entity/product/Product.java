package com.example.demo.entity.product;

import com.example.demo.entity.Cart.Cart;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(length = 32)
    private String imageUrl;

    @Column(length = 32)
    private String productName;

    @Column(length = 32)
    private Integer productNum;

    @Column(length = 32)
    private Integer discount;

    @Column(length = 32)
    private Integer productPrice;

    @Column(length = 32)
    private Integer productDiscountPrice;

    @Column(length = 32)
    private String gender;

    @Column
    private String fileName;

    @Column
    private String filePath;

    @Column(length = 32)
    private String rating;


    @CreationTimestamp
    private Date regDate;

    @UpdateTimestamp
    private Date upDate;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    private List<ProductComment> comments;

    @OneToMany(mappedBy = "product",fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    @Fetch(FetchMode.SUBSELECT)
    private List<Cart> cart;

}
