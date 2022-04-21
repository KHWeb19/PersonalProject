package com.example.backend.service;

import com.example.backend.entity.Board;
import com.example.backend.entity.Comment;
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
        //좋아요 등록과 삭제를 따로 구현해서 버튼이 바뀌게해보자
        Board board = boardRepository.findById(boardNo).orElseThrow();
        Member member = memberRepository.findById(memberNo).orElseThrow();

        if(repository.findByMemberAndBoard(member, board).isEmpty()) {
//            repository.save(new Likes(board, member));
            likes.setMember(member);
            likes.setBoard(board);
            repository.save(likes);
            return true;
        } else {
            Optional<Likes> maybeLikes = repository.findByMemberAndBoard(member, board);
            Likes findLikes = maybeLikes.get();
            repository.deleteById(findLikes.getLikedNo());
            return false;
        }
    }

    @Override
    public List<Likes> list(Long memberNo) {
        return repository.findAllByMemberNo(Long.valueOf(memberNo));
    }
//    @Override
//    public void remove(Integer likesNo) {
//        repository.deleteById(Long.valueOf(likesNo));
//    }
}
