package com.example.backend.controller.board.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@NoArgsConstructor
public class SeatNowRequest {

    private Integer restSeats;

    public SeatNowRequest(Integer restSeats) {
        this.restSeats = restSeats;

    }
}
