package com.example.demo.entity.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Data
@Entity
@NoArgsConstructor
public class ProductComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentNo;
    @NotNull
    @Column
    private String writer;
    @NotNull
    @Column
    private String comment;

    @Column
    private String fileName;

    @CreatedDate
    private String regDate = LocalDateTime.now().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));

    @UpdateTimestamp
    private LocalDateTime updDate;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "product_productId")
    private Product product;

    public ProductComment(String comment, String writer, String fileName){
        this.comment = comment;
        this.writer= writer;
        this.fileName = fileName;
    }
}
