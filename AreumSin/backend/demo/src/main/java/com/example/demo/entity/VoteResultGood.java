package com.example.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class VoteResultGood {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VOTE_RESULT_GOOD_NO")
    private Integer voteResultGoodNo;

    @Column
    private String Id;

    @ManyToOne
    @JoinColumn(name = "VOTE_NO")
    private Vote vote;

    public static VoteResultGood voteResultCreate(String id, Vote vote){
        VoteResultGood voteResult = new VoteResultGood();

        voteResult.setId(id);
        voteResult.setVote(vote);

        return voteResult;
    }
}
