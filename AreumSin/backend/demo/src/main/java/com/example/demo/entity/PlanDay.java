package com.example.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class PlanDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PLAN_DAY_NO")
    private Integer planDayNo;

    @Column(name = "USER_ID", nullable = false)
    private String id;

    @ManyToOne
    @JoinColumn(name = "PLAN_NO")
    private Plan plan;

    @Column
    private Integer day;

    @Lob
    private String content;

    @CreationTimestamp
    private Date regDate;

    public static PlanDay createPlanDay(String id, String content, Integer day, Plan plan){

        PlanDay planDay = new PlanDay();

        planDay.setPlan(plan);
        planDay.setId(id);
        planDay.setDay(day);
        planDay.setContent(content);

        return planDay;
    }

}
