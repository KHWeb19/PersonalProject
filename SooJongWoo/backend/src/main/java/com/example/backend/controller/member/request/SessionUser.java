package com.example.backend.controller.member.request;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {

    private String userId;

    public SessionUser(String userId) {
        this.userId = userId;
    }
}
