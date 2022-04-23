package com.example.demo.entity.review;

import com.example.demo.entity.communityBoard.CommunityBoard;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class ReviewLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name= "review_reviewNo")
    @JsonIgnore
    private Review review;

    @Column
    private String who;

    public ReviewLike(String who, Review review) {
        this.review = review;
        this.who = who;
    }
}
