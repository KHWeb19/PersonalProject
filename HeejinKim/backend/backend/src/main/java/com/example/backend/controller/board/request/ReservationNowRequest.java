package com.example.backend.controller.board.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@NoArgsConstructor
public class ReservationNowRequest {

    private Long restSeats;

    public ReservationNowRequest(Long restSeats) {
        this.restSeats = restSeats;

    }
}
