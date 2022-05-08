
/*package com.example.backend.service.reservation;

import com.example.backend.entity.StudyRoom;
import com.example.backend.repository.reservation.ReservationRepository;
import com.example.backend.repository.reservation.StudyRoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
public class StudyRoomServiceImpl implements StudyRoomService {

    @Autowired
    private ReservationRepository rsvRepository;

    @Autowired
    private StudyRoomRepository srRepository;

    //자리 배치 등록하기
    @Transactional
    @Override
    public void seatRegister(StudyRoom studyRoom) {
        srRepository.save(studyRoom);
    }

    //자리 리스트 가져오기
    @Transactional
    @Override
    public List<StudyRoom> list() {
        return srRepository.findAll(Sort.by(Sort.Direction.DESC, "seatRsvNo"));
    }

    //자리 업데이트 된 것
    @Transactional
    @Override
    public void updateSeat(StudyRoom studyRoom) {

        srRepository.save(studyRoom);

    }
}

 */
