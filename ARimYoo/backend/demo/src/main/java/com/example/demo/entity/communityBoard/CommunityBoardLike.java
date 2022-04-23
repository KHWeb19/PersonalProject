package com.example.demo.entity.communityBoard;

import com.example.demo.entity.Member;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class CommunityBoardLike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name= "communityBoard_boardNo")
    @JsonIgnore
    private CommunityBoard communityBoard;

    @Column
    private String who;

    public CommunityBoardLike(String who, CommunityBoard communityBoard) {
        this.communityBoard = communityBoard;
        this.who = who;
    }
}
