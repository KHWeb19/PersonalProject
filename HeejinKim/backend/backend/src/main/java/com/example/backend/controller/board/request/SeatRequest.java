package com.example.backend.controller.board.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@NoArgsConstructor
public class SeatRequest {

    //자리가 string (reservation)
    private String  seatNum;
    private Integer seatRows;
    private Integer seatCols;

    public SeatRequest(Integer rows, Integer cols,String seatNum) {
        this.seatRows = rows;
        this.seatCols = cols;
        this.seatNum = seatNum;

    }
}


