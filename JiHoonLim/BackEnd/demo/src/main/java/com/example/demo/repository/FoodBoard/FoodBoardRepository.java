package com.example.demo.repository.FoodBoard;

import com.example.demo.entity.FoodBoard.FoodBoard;
import com.example.demo.entity.Member.MemberCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.web.bind.annotation.PathVariable;


import javax.transaction.Transactional;
import java.util.List;

public interface FoodBoardRepository extends JpaRepository<FoodBoard, Long> {

    @Transactional
    @Modifying
    @Query("update FoodBoard vc set vc.viewCount = vc.viewCount + 1 where vc.boardNo = :boardNo")
    void updateViewCount(@Param("boardNo") Long boardNo);

    @Transactional
    @Modifying
    @Query("update FoodBoard lc set lc.likeCount = lc.likeCount + 1 where lc.boardNo = :boardNo")
    void updateLikeCount(@Param("boardNo") Long boardNo);

    List<FoodBoard> findTop10ByOrderByRankScoreDesc();

    List<FoodBoard> findByNameContaining(String keyWord);

    @Transactional
    @Modifying
    @Query("update FoodBoard rs set rs.rankScore = rs.viewCount + (2 * rs.likeCount) where rs.boardNo = :boardNo")
    void setRankScore(@Param("boardNo") Long boardNo);

    //회원 번호를 받아와서 회원의 보관함 boardNo를 받아와서 foodBoard 에서 그 번호들 을 찾은 게시물들을 리스트로 반환하려했습니다.
    //@Transactional
    //@Query(value = "select * from food_board where board_no in (select food_board_board_no from member_cart where member_no = :member_no)",nativeQuery = true)
    //public List<FoodBoard> selectFoodWithMemberNo(Long member_no);

    //회원 번호를 받아와서 회원의 보관함 boardNo를 받아와야함.
    @Query("select fb from FoodBoard fb join fb.myCarts mc where mc.memberNo = :memberNo")
    List<FoodBoard> findFoodBoardListByMemberCart(@Param("memberNo")Long memberNo);


}
