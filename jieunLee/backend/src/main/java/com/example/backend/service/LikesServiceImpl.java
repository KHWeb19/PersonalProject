package com.example.backend.service;

import com.example.backend.entity.Board;
import com.example.backend.entity.Likes;
import com.example.backend.entity.Member;
import com.example.backend.repository.BoardRepository;
import com.example.backend.repository.LikesRepository;
import com.example.backend.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikesServiceImpl implements LikesService {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    LikesRepository repository;

    @Override
    public boolean register(Long boardNo, Long memberNo, Likes likes) {
        Board board = boardRepository.findById(boardNo).orElseThrow();
        Member member = memberRepository.findById(memberNo).orElseThrow();

        if(repository.findByMemberAndBoard(member, board).isEmpty()) {
            likes.setMember(member);
            likes.setBoard(board);
            repository.save(likes);
            return true;
        } else {
            Optional<Likes> maybeLikes = repository.findByMemberAndBoard(member, board);
            repository.deleteById(maybeLikes.get().getLikedNo());
            return false;
        }
    }

    @Override
    public Likes likes(Long boardNo, Long memberNo) {
        Optional<Likes> maybeReadLikes = repository.findLikesBoardNoAndMemberNo(Long.valueOf(boardNo), Long.valueOf(memberNo));
        if (maybeReadLikes.equals(Optional.empty())) {
            return null;
        }
        return maybeReadLikes.get();
    }

    @Override
    public List<Likes> list(Long boardNo) {
        return repository.findByBoardNo(Long.valueOf(boardNo));
    }

    @Override
    public List<Likes> myLikes(Long memberNo) {
        return repository.findByMemberNo(Long.valueOf(memberNo));
    }
}
