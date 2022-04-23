package com.example.backend.service.reservation;

import com.example.backend.entity.Board;
import com.example.backend.entity.Reservation;
import com.example.backend.entity.StudyRoom;

import java.util.List;

public interface ReservationService {
    /*
    public void seatInsert(Reservation reservation);
    public List<Reservation> list (Long memberNo);
    public void remove (Long seatNo) ;*/


    public List<Reservation> getPickedSeats(Reservation reservation);
    public List<StudyRoom> getStudyRoom(StudyRoom room);
    public void makeReservation( Reservation reservation);

    //public List<Search_Reservation>getReservation(Search_Reservation movr);
}
