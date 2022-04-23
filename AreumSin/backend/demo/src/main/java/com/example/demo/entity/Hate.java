package com.example.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "hateTable")
public class Hate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HATE_NO")
    private Integer hateNo;

    @Column
    private String id;

    @ManyToOne
    @JoinColumn(name = "planDayNo")
    private PlanDay planDay;

    public static Hate createHateMember(String id, PlanDay planDay){
        Hate hate = new Hate();

        hate.setId(id);
        hate.setPlanDay(planDay);

        return hate;
    }
}
