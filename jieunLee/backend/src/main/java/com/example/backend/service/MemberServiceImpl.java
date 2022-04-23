package com.example.backend.service;

import com.example.backend.controller.MemberRequest;
import com.example.backend.entity.Board;
import com.example.backend.entity.Comment;
import com.example.backend.entity.Likes;
import com.example.backend.entity.Member;
import com.example.backend.repository.BoardRepository;
import com.example.backend.repository.CommentRepository;
import com.example.backend.repository.LikesRepository;
import com.example.backend.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    LikesRepository likesRepository;

    @Autowired
    CommentRepository commentRepository;

    @Override
    public List<Member> list() {
        return memberRepository.findAll(Sort.by(Sort.Direction.DESC, "memberNo"));
    }

    @Override
    public List<Member> search(String keyWord) {
        return memberRepository.findByMemberIdContainingOrMemberNameContaining(keyWord, keyWord);
    }

    @Override
    public void register(MemberRequest memberRequest) {
        String encodedPassword = passwordEncoder.encode(memberRequest.getPassword());
        memberRequest.setPassword(encodedPassword);

        Member memberEntity = new Member(
                memberRequest.getMemberName(),
                memberRequest.getMemberId(),
                memberRequest.getPassword(),
                memberRequest.getPasswordHint()
        );

        memberRepository.save(memberEntity);
    }

    @Override
    public MemberRequest login(MemberRequest memberRequest) {
        Optional<Member> maybeMember = memberRepository.findByUserId(memberRequest.getMemberId());

        if (maybeMember.equals(Optional.empty())) {
            log.info("이런 사람 없다!");
            return null;
        }

        Member loginMember = maybeMember.get();

        if (!passwordEncoder.matches(memberRequest.getPassword(), loginMember.getPassword())) {
            log.info("비밀번호를 잘못 입력했습니다!");
            return null;
        }

        if (loginMember.getMemberId().equals(memberRequest.getMemberId())) {

            memberRequest.setMemberNo(loginMember.getMemberNo());
            memberRequest.setMemberName(loginMember.getMemberName());
            memberRequest.setMemberId(loginMember.getMemberId());
            memberRequest.setPassword(loginMember.getPassword());
            memberRequest.setPasswordHint(loginMember.getPasswordHint());
            memberRequest.setImageName(loginMember.getImageName());
            memberRequest.setMemberWeb(loginMember.getMemberWeb());
            memberRequest.setMemberIntro(loginMember.getMemberIntro());
            memberRequest.setRegData(loginMember.getRegDate());
        }

        MemberRequest response = new MemberRequest(
                memberRequest.getMemberNo(),
                memberRequest.getMemberName(),
                memberRequest.getMemberId(),
                null,
                memberRequest.getPasswordHint(),
                memberRequest.getImageName(),
                memberRequest.getMemberWeb(),
                memberRequest.getMemberIntro(),
                memberRequest.getRegData());

        return response;
    }

    @Override
    public MemberRequest forget(MemberRequest memberRequest) {
        Optional<Member> maybeMember = memberRepository.findByUserId(memberRequest.getMemberId());

        if (maybeMember.equals(Optional.empty())) {
            log.info("이런 사람 없다!");
            return null;
        }

        Member loginMember = maybeMember.get();

        if (!memberRequest.getPasswordHint().matches(loginMember.getPasswordHint())) {
            log.info("힌트 답 잘못 입력!");
            return null;
        }

        if (loginMember.getMemberId().equals(memberRequest.getMemberId())) {
            memberRequest.setMemberNo(loginMember.getMemberNo());
        }

        MemberRequest response = new MemberRequest(
                memberRequest.getMemberNo(),
                memberRequest.getMemberName(),
                memberRequest.getMemberId(),
                null,
                memberRequest.getPasswordHint(),
                memberRequest.getImageName(),
                memberRequest.getMemberWeb(),
                memberRequest.getMemberIntro(),
                memberRequest.getRegData());

        return response;
    }

    @Override
    public Member read(Long memberNo) {
        Optional<Member> maybeReadMember = memberRepository.findById(Long.valueOf(memberNo));

        if (maybeReadMember.equals(Optional.empty())) {

            return null;
        }

        return maybeReadMember.get();
    }

    @Override
    public void profile(Member member) {

        memberRepository.save(member);
    }

    @Override
    public void modify(Member member) {
        String encodedPassword = passwordEncoder.encode(member.getPassword());
        member.setPassword(encodedPassword);

        memberRepository.save(member);
    }

    @Override
    public void remove(Long memberNo) {
        Member member = memberRepository.findById(memberNo).orElseThrow();
        Optional<Board> maybeBoard = boardRepository.findByMember(member);
        if(!maybeBoard.isEmpty()) {
            Optional<Comment> maybeComment = commentRepository.findByBoard(maybeBoard.get());
            if(!maybeComment.isEmpty()) {
                commentRepository.deleteById(maybeComment.get().getCommentNo());
            }
            Optional<Likes> maybeLikes = likesRepository.findByBoard(maybeBoard.get());
            if(!maybeLikes.isEmpty()) {
                likesRepository.deleteById(maybeLikes.get().getLikedNo());
            }
            boardRepository.deleteById(maybeBoard.get().getBoardNo());
        }
        memberRepository.deleteById(Long.valueOf(memberNo));
    }
}
