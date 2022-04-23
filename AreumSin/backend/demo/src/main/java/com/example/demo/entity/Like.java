package com.example.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "likeTable")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LIKE_NO")
    private Integer likeNo;

    @Column
    private String id;

    @ManyToOne
    @JoinColumn(name = "planDayNo")
    private PlanDay planDay;

    public static Like createLikeMember(String id, PlanDay planDay){
        Like like = new Like();

        like.setId(id);
        like.setPlanDay(planDay);

        return like;
    }

}
