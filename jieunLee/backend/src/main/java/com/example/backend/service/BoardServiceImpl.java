package com.example.backend.service;

import com.example.backend.entity.*;
import com.example.backend.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardRepository repository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    LikesRepository likesRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    FollowRepository followRepository;

    @Override
    public void register(Integer memberNo, Board board) {
        Optional<Member> maybeMember = memberRepository.findById(Long.valueOf(memberNo));
        board.setMember(maybeMember.get());
        repository.save(board);
    }

    @Override
    public List<Board> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));
    }

    @Override
    public List<Board> memberBoardList(Long memberNo) {
        List<Board> boards = repository.findByMemberNoOrderByBoardNoDesc(Long.valueOf(memberNo));
        return boards;
    }

    @Override
    public List<Board> followBoardList(Long memberNo) {
        List<Follow> followList = followRepository.findByMy(Long.valueOf(memberNo));
        List<Board> myBoards = repository.findByMemberNoOrderByBoardNoDesc(Long.valueOf(memberNo));

        for (Follow f : followList) {
            List<Board> boards = repository.findByMemberNoOrderByBoardNoDesc(Long.valueOf(f.getYour().getMemberNo()));
            for (Board b : boards) {
                myBoards.add(b);
            }
        }
        return myBoards;
    }

    @Override
    public Board read(Integer boardNo) {
        Optional<Board> maybeReadBoard = repository.findById(Long.valueOf(boardNo));

        if (maybeReadBoard.equals(Optional.empty())) {
            return null;
        }

        return maybeReadBoard.get();
    }

    @Override
    public void modify(Board board, Integer memberNo) {
        Optional<Member> maybeMember = memberRepository.findById(Long.valueOf(memberNo));
        board.setMember(maybeMember.get());
        repository.save(board);
    }

    @Override
    public void remove(Long boardNo) {
        List<Comment> maybeComment = commentRepository.findAllCommentsBoardNo(boardNo);
        if(!maybeComment.isEmpty()) {
            for (Comment comment : maybeComment) {
                commentRepository.delete(comment);
            }
        }
        List<Likes> maybeLikes = likesRepository.findAllLikesBoardNo(boardNo);
        if(!maybeLikes.isEmpty()) {
            for (Likes likes : maybeLikes) {
                likesRepository.delete(likes);
            }
        }
        repository.deleteById(Long.valueOf(boardNo));
    }
}
