/*package com.example.backend.senter.reservation;

import com.example.backend.entity.Reservation;
import com.example.backend.entity.StudyRoom;



import java.util.List;

public interface StudyRoomService {

    //일단 자리를 등록해야되는데 이것을 다른 것이 했는 지 한번 살펴보고
    //1) 자리 등록하기
    //2) 읽으면 자리 가져오기
    //3) 시간당 남은 자리 업데이트 ---이런건 수정인가?put으로 쓰게 ?

    public void seatRegister (StudyRoom studyRoom);     //자리 등록
    public List<StudyRoom> list ();                     //자리 리스트 가져오기
    public void updateSeat (StudyRoom studyRoom);       //자리 업데이트


    //원래는 시간당 남은 자리 가져와서 보여주기 해야되는데 굳이 자리 업데이트했는데
    //select 시간해서 보여줄 필요가 있을까? ----read처럼??
    //일단 read는 배제하고 사용해봄





    //시간당 남은자리 가져오기
    //@Transactional
    //@Query(value ="SELECT rest_seats, sr.rows, sr.cols FROM study_room sr, seat_time t WHERE t.seat_time = #{seatTime}", nativeQuery = true)
    //List<StudyRoom> getRestSeats(@Param("seatTime") String seatTime);
    //시간당 남은 좌석 업데이트 하기
    //@SQLUpdate (sql = "UPDATE seat_time SET rest_seats = #{restSeats} WHERE seat_time = #{seatTime}")
    //int updateRestSeats(@Param("restSeats") int restSeats, @Param("time") String seatTime);
}

 */
