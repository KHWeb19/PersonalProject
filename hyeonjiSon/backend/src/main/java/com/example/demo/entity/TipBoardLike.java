package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class TipBoardLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "tipBoard_boardNo")
    @JsonIgnore
    private TipBoard tipBoard;

    @Column
    private String who;

    public TipBoardLike(String who, TipBoard tipBoard) {
        this.tipBoard = tipBoard;
        this.who = who;
    }

}
