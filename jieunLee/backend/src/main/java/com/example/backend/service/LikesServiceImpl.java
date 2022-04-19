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
    public void register(Integer boardNo, Integer memberNo, Likes likes) {

//        if(repository.findByMemberNoAndBoard(Long.valueOf(likes.getMemberNo()), likes.getBoard()).isEmpty()) {
            Optional<Board> maybeBoard = boardRepository.findById(Long.valueOf(boardNo));
            likes.setBoard(maybeBoard.get());
            Optional<Member> maybeMember = memberRepository.findById(Long.valueOf(memberNo));
            likes.setMember(maybeMember.get());

            repository.save(likes);
//        } else {
//            repository.deleteById(Long.valueOf(likes.getLikedNo()));
//        }
    }
    @Override
    public void remove(Integer likesNo) {
        repository.deleteById(Long.valueOf(likesNo));
    }
}
