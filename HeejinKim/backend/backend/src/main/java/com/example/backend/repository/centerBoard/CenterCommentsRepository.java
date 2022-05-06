package com.example.backend.repository.centerBoard;

import com.example.backend.entity.BoardComments;
import com.example.backend.entity.Center;
import com.example.backend.entity.CenterComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface CenterCommentsRepository extends JpaRepository<CenterComments,Long> {


    @Transactional
    @Query(value = "select * from center_comments where center_no = :centerNo",nativeQuery = true)
    List<CenterComments> findAllBoardCommentByBoardId(Long centerNo);
}

