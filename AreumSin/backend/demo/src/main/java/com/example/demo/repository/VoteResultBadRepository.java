package com.example.demo.repository;

import com.example.demo.entity.VoteResultBad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface VoteResultBadRepository extends JpaRepository<VoteResultBad, Integer> {

    @Transactional
    @Query("select vb from VoteResultBad vb where vb.Id = :id and vb.vote.voteNo = :voteNo")
    Optional<VoteResultBad> findByMaybeVotedMember(Integer voteNo, String id);

    @Transactional
    @Query("select vb from VoteResultBad vb where vb.Id = :id and vb.vote.voteNo = :voteNo")
    VoteResultBad findByVoteMember(Integer voteNo, String id);
}
