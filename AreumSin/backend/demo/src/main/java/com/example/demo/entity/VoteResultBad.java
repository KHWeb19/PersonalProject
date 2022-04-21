package com.example.demo.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class VoteResultBad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VOTE_RESULT_BAD_NO")
    private Integer voteResultBadNo;

    @Column
    private String Id;

    @ManyToOne
    @JoinColumn(name = "VOTE_NO")
    private Vote vote;

    public static VoteResultBad voteResultCreate(String id, Vote vote){
        VoteResultBad voteResult = new VoteResultBad();

        voteResult.setId(id);
        voteResult.setVote(vote);

        return voteResult;
    }
}
