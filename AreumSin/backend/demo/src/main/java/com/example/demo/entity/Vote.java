package com.example.demo.entity;

import com.example.demo.repository.VoteRepository;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "vote_Table")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VOTE_NO")
    private Integer voteNo;

    @Lob
    private String voteContent;

    @ManyToOne
    @JoinColumn(name = "PLAN_NO")
    private Plan plan;

    @Column
    private Integer agreement;

    @Column
    private Integer opposition;

    public static Vote voteCreate(String voteContent, Plan plan){
        Vote vote = new Vote();

        vote.setVoteContent(voteContent);
        vote.setPlan(plan);
        vote.setAgreement(0);
        vote.setOpposition(0);

        return vote;
    }

    public void voteResultAgreement(Vote vote, boolean check){
        int count = vote.getAgreement();

        if(check){
            count++;
        }else{
            count--;
        }

        vote.setAgreement(count);
    }

    public void voteResultOpposition(Vote vote, boolean check){
        int count = vote.getOpposition();

        if(check){
            count++;
        }else{
            count--;
        }

        vote.setOpposition(count);
    }

}
