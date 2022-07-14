package com.example.backend.controller.member.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class ResponseSession {
    String userId;
    String hashcode;

    public ResponseSession(String userId, String hashcode) {
        this.userId = userId;
        this.hashcode = hashcode;
    }
}
