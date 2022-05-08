package com.example.backend.controller.board.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@NoArgsConstructor
public class SeatNowRequest {

    private Integer restSeats;
    private String seatNumber;
    private String seatTime;

    public SeatNowRequest(Integer restSeats,String seatNumber, String seatTime) {
        this.restSeats = restSeats;
        this.seatNumber = seatNumber;
        this.seatTime = seatTime;

    }
}
