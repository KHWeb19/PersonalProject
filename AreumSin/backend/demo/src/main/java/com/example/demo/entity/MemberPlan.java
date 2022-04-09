package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class MemberPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memberPlanNo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_NO")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "PLAN_NO")
    private Plan plan;

    public MemberPlan(Member member, Plan plan){
        this.member = member;
        this.plan = plan;
    }

}
