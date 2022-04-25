package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "likes")
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="like_no")
    private Long likedNo;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "member_no")
    private Member member;

    @JsonBackReference(value="board-likes")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "board_no")
    private Board board;
}