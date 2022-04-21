package com.example.demo.service.boardComment;

import com.example.demo.controller.boardCommentController.request.BoardCommentRequest;
import com.example.demo.entity.boardComment.BoardComment;
import com.example.demo.entity.booking.BookingInfo;
import com.example.demo.repository.boardComment.BoardCommentRepository;
import com.example.demo.repository.booking.BookingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import static java.lang.Long.valueOf;

@Slf4j
@Service
public class BoardCommentServiceImpl implements BoardCommentService {

    @Autowired
    BoardCommentRepository repository;

    @Autowired
    BookingRepository bookingRepository;

    @Transactional
    @Override
    public void includeCommentRegister(BoardCommentRequest info, String originalFilename) {
        String putLink = info.getBookingNo()+"."+info.getId()+"."+originalFilename;

        Optional<BookingInfo> bookingInfo = bookingRepository.findById(info.getBookingNo());
        BookingInfo bookingInfo1 = bookingInfo.get();

        BoardComment boardComment = new BoardComment(info.getId(),info.getComments(),putLink,bookingInfo1 );
        repository.save(boardComment);
    }

    @Transactional
    @Override
    public void exceptFileCommentRegister(BoardCommentRequest info) {
        Optional<BookingInfo> bookingInfo = bookingRepository.findById(info.getBookingNo());
        BookingInfo bookingInfo2 = bookingInfo.get();
        log.info("bookingInfo2 :"+bookingInfo2);

        BoardComment boardComment2 = new BoardComment(info.getId(),info.getComments(), bookingInfo2);
        repository.save(boardComment2);

    }

    @Transactional
    @Override
    public List<BoardComment> list(Integer bookingNo) {
        return repository.findBookingNoLost(Long.valueOf(bookingNo));
    }
}
