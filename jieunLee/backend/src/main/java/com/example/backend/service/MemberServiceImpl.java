package com.example.backend.service;

import com.example.backend.controller.MemberRequest;
import com.example.backend.entity.*;
import com.example.backend.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class MemberServiceImpl implements MemberService{

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private LikesRepository likesRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    FollowRepository followRepository;

    @Override
    public List<Member> list() {
        List<Member> randomList = new ArrayList<>();
        List<Member> memberList = memberRepository.findAll();

        int randIdx;
        int[] arr = new int[5];
        boolean isDuplicate = true;
        arr[0] = (int)(Math.random()* memberList.size()+1);
        for (int i=1; i<5; i++) {
            do {
                randIdx = (int)(Math.random()* memberList.size()+1);
                for(int j=0; j<i; j++) {
                    if(arr[j] == randIdx) {
                        isDuplicate = true;
                        break;
                    }
                    isDuplicate = false;
                }

            } while (isDuplicate);
            arr[i] = randIdx;
        }

        for (int i=0; i<5; i++) {
            if (memberRepository.findByMemberNo(Long.valueOf(arr[i]))!=null) {
                Member member = memberRepository.findByMemberNo(Long.valueOf(arr[i]));
                randomList.add(member);
            }
        }
        return randomList;

    }

    @Override
    public List<Member> search(String keyWord) {
        return memberRepository.findByMemberIdContainingOrMemberNameContaining(keyWord, keyWord);
    }

    @Override
    public Member register(MemberRequest memberRequest) {
        Optional<Member> maybeMember = memberRepository.findByUserId(memberRequest.getMemberId());

        if (!maybeMember.equals(Optional.empty())) {
            log.info("아이디 중복!");
            return null;
        } else {
            String encodedPassword = passwordEncoder.encode(memberRequest.getPassword());
            memberRequest.setPassword(encodedPassword);

            Member memberEntity = new Member(
                    memberRequest.getMemberName(),
                    memberRequest.getMemberId(),
                    memberRequest.getPassword(),
                    memberRequest.getPasswordHint()
            );
            memberRepository.save(memberEntity);
            return memberEntity;
        }
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
        List<Comment> memberComment = commentRepository.findAllCommentsMemberNo(memberNo);
        if(!memberComment.isEmpty()) {
            for (Comment comment : memberComment) {
                commentRepository.delete(comment);
            }
        }
        List<Likes> memberLikes = likesRepository.findAllLikesMemberNo(memberNo);
        if(!memberLikes.isEmpty()) {
            for (Likes likes : memberLikes) {
                likesRepository.delete(likes);
            }
        }

        List<Follow> memberFollowings = followRepository.findAllFollowingsMemberNo(memberNo);
        if(!memberFollowings.isEmpty()) {
            for (Follow follow : memberFollowings) {
                followRepository.delete(follow);
            }
        }

        List<Follow> memberFollowers = followRepository.findAllFollowersMemberNo(memberNo);
        if(!memberFollowers.isEmpty()) {
            for (Follow follow : memberFollowers) {
                followRepository.delete(follow);
            }
        }

        List<Board> maybeBoard = boardRepository.findAllBoardsMemberNo(memberNo);
        if(!maybeBoard.isEmpty()) {
            for (Board board : maybeBoard) {
                List<Comment> maybeComment = commentRepository.findAllCommentsBoardNo(board.getBoardNo());
                if(!maybeComment.isEmpty()) {
                    for (Comment comment : maybeComment) {
                        commentRepository.delete(comment);
                    }
                }
                List<Likes> maybeLikes = likesRepository.findAllLikesBoardNo(board.getBoardNo());
                if(!maybeLikes.isEmpty()) {
                    for (Likes likes : maybeLikes) {
                        likesRepository.delete(likes);
                    }
                }
                boardRepository.delete(board);
            }
        }
        memberRepository.deleteById(Long.valueOf(memberNo));
    }
}
