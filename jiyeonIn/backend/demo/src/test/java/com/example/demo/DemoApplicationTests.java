package com.example.demo;

import com.example.demo.entity.boardComment.BoardComment;
import com.example.demo.entity.booking.BookingInfo;
import com.example.demo.repository.boardComment.BoardCommentRepository;
import com.example.demo.repository.booking.BookingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	BoardCommentRepository boardCommentRepository;

	@Test
	void 테스트() {
		Optional<BookingInfo> bookingInfo = bookingRepository.findById(11L);
		BookingInfo bookingInfo2 = bookingInfo.get();

		Optional<BoardComment> boardComment = boardCommentRepository.findById(3L);
		BoardComment boardComment1 = boardComment.get();

		BoardComment boardComment2 = new BoardComment("manager","sdf", bookingInfo2);

		BoardComment boardComment3 = new BoardComment(boardComment1.getId(), boardComment1.getComments(),bookingInfo2,boardComment2);

		boardCommentRepository.save(boardComment3);

	}

}
