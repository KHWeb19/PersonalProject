package com.example.demo.entity.personalProject;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="category_name")
    private String categoryName;

    private String description;

    @Column(name="image_url")
    private String imageUrl;

}
