package com.example.backend.controller.reservation.request;

import com.example.backend.entity.jpa.Room;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Data
@Slf4j
@NoArgsConstructor
public class RoomRequest {
    private Date reservedDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private Date regDate;
    private Long bookNo;
    private String roomId;
    private String period;
    private String personNum;
    private String bankName;
    private String price;
    private String userId;
    private Integer roomCnt;

    // 수정작성

    public Room toEntity() {
        Room build = Room.builder()
                .roomId(roomId)
                .period(period)
                .personNum(personNum)
                .bankName(bankName)
                .price(price)
                .userId(userId)
                .roomCnt(roomCnt)
                .regDate(regDate)
                .build();
        return build;


    }
    @Builder
    public RoomRequest(Date reservedDate, Long bookNo, String roomId, String period, String personNum, String bankName, String price, String userId, Integer roomCnt, Date regDate ) {
        this.reservedDate =reservedDate;
        this.bookNo = bookNo;
        this.roomId = roomId;
        this.period =period;
        this.personNum = personNum;
        this.bankName = bankName;
        this.price = price;
        this.userId =userId;
        this.roomCnt =roomCnt;
        this.regDate = regDate;
    }

}
