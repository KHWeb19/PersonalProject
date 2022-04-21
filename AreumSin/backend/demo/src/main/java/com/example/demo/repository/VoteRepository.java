package com.example.demo.repository;

import com.example.demo.entity.Hate;
import com.example.demo.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface VoteRepository extends JpaRepository<Vote, Integer> {

    @Transactional
    @Query("select v from Vote v where v.plan.planNo = :planNo")
    List<Vote> findAllVote(Integer planNo);

    @Transactional
    @Query("select v from Vote v where v.voteNo = :voteNo")
    Vote findVoteByVoteNo(Integer voteNo);
}
