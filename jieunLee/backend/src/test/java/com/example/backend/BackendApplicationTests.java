package com.example.backend;

import com.example.backend.entity.*;
import com.example.backend.repository.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BackendApplicationTests {
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

	@Test
	void 회원탈퇴() {
		List<Board> maybeBoard = boardRepository.findAllBoardsMemberNo((long) 1);
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
		memberRepository.deleteById(Long.valueOf(1));
	}

	@Test
	void 게시글삭제() {
			List<Board> maybeBoard = boardRepository.findAllBoardsMemberNo((long) 1);
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
		memberRepository.deleteById(Long.valueOf(1));
	}

	@Test
	public List<Member> 팔로우리스트() {
		List<Member> followList = memberRepository.findFollowingsByMemberNo(Long.valueOf(2));
		return followList;
	}
}
