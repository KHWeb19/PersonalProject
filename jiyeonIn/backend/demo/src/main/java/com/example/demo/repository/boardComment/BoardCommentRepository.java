package com.example.demo.repository.boardComment;

import com.example.demo.entity.boardComment.BoardComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface BoardCommentRepository extends JpaRepository<BoardComment,Long> {

    @Transactional
    @Query(value = "select * from board_comment where booking_no = :bookingNo order by parent_no asc",nativeQuery = true)
    List<BoardComment> findBookingNoLost(Long bookingNo);

    @Transactional
    @Query(value = "select max(parent_no) from board_comment where booking_no = :bookingNo",nativeQuery = true)
    public Long findMax(Long bookingNo);

    @Transactional
    @Query(value = "select max(children_no) from board_comment where parent_no = :findNoParent",nativeQuery = true)
    public Long findMaxParent(Long findNoParent);
}
