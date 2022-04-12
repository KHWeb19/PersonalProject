package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
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

    @OneToMany(mappedBy = "plan", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<MemberPlan> memberPlans = new ArrayList<>();

    public void addPlanMember(MemberPlan memberPlan){
        memberPlans.add(memberPlan);
        memberPlan.setPlan(this);
    }

    public static Plan createPlan(String planName, String planDate, String placeName, MemberPlan... memberPlans) {
        Plan plan = new Plan();

        plan.setPlanName(planName);
        plan.setPlanDate(planDate);
        plan.setPlaceName(placeName);

        for(MemberPlan memberPlan : memberPlans) {
            plan.addPlanMember(memberPlan);
        }
        return plan;
    }


}
