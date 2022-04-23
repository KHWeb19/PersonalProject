package com.example.demo.repository;

import com.example.demo.entity.VoteResultBad;
import com.example.demo.entity.VoteResultGood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface VoteResultGoodRepository extends JpaRepository<VoteResultGood, Integer> {

    @Transactional
    @Query("select vg from VoteResultGood vg where vg.Id = :id and vg.vote.voteNo = :voteNo")
    Optional<VoteResultGood> findByMaybeVotedMember(Integer voteNo, String id);

    @Transactional
    @Query("select vg from VoteResultGood vg where vg.Id = :id and vg.vote.voteNo = :voteNo")
    VoteResultGood findByVoteMember(Integer voteNo, String id);
}
