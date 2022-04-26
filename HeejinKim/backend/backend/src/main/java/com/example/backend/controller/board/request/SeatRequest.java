package com.example.backend.controller.board.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@NoArgsConstructor
public class SeatRequest {

    private Integer restSeats;
    private Integer seatNumber;
    private Integer seatRows;
    private Integer seatCols;

    public SeatRequest(Integer restSeats,Integer rows, Integer cols,Integer seatNumber) {
        this.seatRows = rows;
        this.seatCols = cols;
        this.restSeats = restSeats;
        this.seatNumber = seatNumber;

    }
}


