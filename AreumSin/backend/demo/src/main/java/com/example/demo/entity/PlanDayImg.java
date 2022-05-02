package com.example.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class PlanDayImg {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLAN_DAY_IMG_NO")
    private Integer planDayImgNo;

    @Column
    private String imgSrc;

    @ManyToOne
    @JoinColumn(name = "PLAN_DAY_NO")
    private PlanDay planDay;

    public PlanDayImg(String imgSrc, PlanDay planDay) {
        this.imgSrc = imgSrc;
        this.planDay = planDay;
    }

    public PlanDayImg(PlanDay planDay) {
        this.planDay = planDay;
    }
}
