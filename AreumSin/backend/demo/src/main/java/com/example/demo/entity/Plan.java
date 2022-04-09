package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLAN_NO")
    private Integer planNo;

    @Column(nullable = false)
    private String planName;

    @Column(nullable = false)
    private String planDate;

    @Column(nullable = false)
    private String placeName;

    @OneToMany(mappedBy = "plan")
    private List<MemberPlan> memberPlans = new ArrayList<>();

    public Plan(String planName, String planDate, String placeName){
        this.planName = planName;
        this.planDate=planDate;
        this.placeName = placeName;
    }

}
