package com.example.backend.service;

import com.example.backend.controller.BoardRequest;
import com.example.backend.controller.CommentRequest;
import com.example.backend.entity.Board;
import com.example.backend.entity.Comment;
import com.example.backend.entity.Member;
import com.example.backend.repository.BoardRepository;
import com.example.backend.repository.MemberRepository;
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
    private MemberRepository memberRepository;

    @Override
    public void register(Integer memberNo, BoardRequest boardRequest) {

        Optional<Member> maybeBoard = memberRepository.findById(Long.valueOf(memberNo));
        Member member = maybeBoard.get();

        Board boardEntity = Board.builder().
                boardImage(boardRequest.getBoardImage()).
                content(boardRequest.getContent()).
                member(member).
                writer(boardRequest.getWriter())
                .build();

        memberRepository.save(member);
        repository.save(boardEntity);
    }

    @Override
    public List<Board> list() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "boardNo"));
    }

//    @Override
//    public List<Board> memberNoBoardList(Integer memberNo) {
//        List<Board> myBoard = repository.selectMyBoard(Long.valueOf(memberNo));
//        return myBoard;
//    }

    @Override
    public List<Board> memberBoardList(Integer memberNo) {
        List<Board> boards = repository.findBoardByMemberNo(Long.valueOf(memberNo));
        return boards;
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
    public void modify(Board board) {
        repository.save(board);
    }

    @Override
    public void remove(Integer boardNo) {
        repository.deleteById(Long.valueOf(boardNo));
    }
}
