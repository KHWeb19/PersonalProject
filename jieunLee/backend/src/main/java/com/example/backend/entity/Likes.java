package com.example.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @JsonIgnoreProperties({"likes", "boards", "comments", "followings", "followers"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "member_no")
    private Member member;

    @JsonIgnoreProperties({"member"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "board_no")
    private Board board;
}
