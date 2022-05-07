package com.example.backend.repository.centerBoard;

import com.example.backend.entity.Board;
import com.example.backend.entity.BoardComments;
import com.example.backend.entity.Center;
import com.example.backend.entity.CenterComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface CenterCommentsRepository extends JpaRepository<CenterComments,Long> {


    @Transactional
    @Query(value = "select c from CenterComments c join c.center tb where tb.centerNo = :centerNo",nativeQuery = true)
    List<CenterComments> findAllCenterBoardCommentByBoardId(Long centerNo);

    List<CenterComments>findCenterCommentsByCenter(Center center);

    @Transactional
    @Query(value = "select * from center_comments where com_no = :comNo",nativeQuery = true)
    List<BoardComments> findCommentByCommentNo (Long comNo);
}

