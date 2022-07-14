package com.example.backend.controller.reservation.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
@NoArgsConstructor
public class DateRequest {
    private String reservedDate;
}
