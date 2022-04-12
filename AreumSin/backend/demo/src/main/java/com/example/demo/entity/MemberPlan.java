package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.util.Optional;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "member_plan")
public class MemberPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memberPlanNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_NO")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PLAN_NO")
    private Plan plan;

    public static MemberPlan createMemberPlan(Member member){
        MemberPlan memberPlan = new MemberPlan();
        memberPlan.setMember(member);

        return memberPlan;
    }

}
