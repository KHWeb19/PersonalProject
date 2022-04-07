package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer planNo;

    @Column(nullable = false)
    private String planName;

    @Column(nullable = false)
    private String planDate;

    @Column(nullable = false)
    private String placeName;


}
