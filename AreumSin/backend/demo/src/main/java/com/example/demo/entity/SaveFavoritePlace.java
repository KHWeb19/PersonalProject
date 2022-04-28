package com.example.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class SaveFavoritePlace {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FAVORITE_PLACE")
    private Integer favoritePlace;

    @Column
    private String title;

    @Column
    private String x;

    @Column
    private String y;

    @ManyToOne
    @JoinColumn(name = "PLAN_NO")
    private Plan plan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_NO")
    private Member member;

    public SaveFavoritePlace(String title, String x, String y, Plan plan, Member member) {
        this.title = title;
        this.x = x;
        this.y = y;
        this.plan = plan;
        this.member = member;
    }
}
