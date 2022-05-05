package com.example.demo.entity.Cart;

import com.example.demo.entity.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartNo;

    @NotNull
    @Column
    private Long memberNo;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "product_productId")
    private Product product;


}
