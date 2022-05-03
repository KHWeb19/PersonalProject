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

		Long findNoParent = boardCommentRepository.findMax(11l);
		Long findNoChild = 0l;

		if(findNoParent == null) {
			findNoParent = 1l;
		}else {
			findNoParent +=1l;
		}

		BoardComment boardComment2 = new BoardComment("manager","sdf", findNoParent, 0l, bookingInfo2);
		boardCommentRepository.save(boardComment2);

	}

}
