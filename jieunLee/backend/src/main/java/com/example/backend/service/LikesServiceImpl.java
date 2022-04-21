package com.example.backend.service;

import com.example.backend.entity.Board;
import com.example.backend.entity.Likes;
import com.example.backend.entity.Member;
import com.example.backend.repository.BoardRepository;
import com.example.backend.repository.LikesRepository;
import com.example.backend.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public boolean register(Long boardNo, Long memberNo) {
        Board board = boardRepository.findById(boardNo).orElseThrow();
        Member member = memberRepository.findById(memberNo).orElseThrow();

        if(repository.findByMemberAndBoard(member, board).isEmpty()) {
            repository.save(new Likes(board, member));
            return true;
        } else {
            Optional<Likes> findLikes = repository.findByMemberAndBoard(member, board);
            Likes likes = findLikes.get();
            repository.deleteById(likes.getLikedNo());
            return false;
        }
    }
//    @Override
//    public void remove(Integer likesNo) {
//        repository.deleteById(Long.valueOf(likesNo));
//    }
}
