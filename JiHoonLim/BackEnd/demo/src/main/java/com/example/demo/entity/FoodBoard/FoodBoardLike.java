package com.example.demo.entity.FoodBoard;

import com.example.demo.entity.Member.Member;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class FoodBoardLike {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "foodBoard_boardNo")
    private FoodBoard foodBoard;

    @Column
    private String member;

    public FoodBoardLike(FoodBoard foodBoard, String member){
        this.foodBoard = foodBoard;
        this.member = member;
    }
}
