package com.example.demo.dto.response;


import lombok.Data;

@Data
public class DuplicationCheck {
    private String message;

    public DuplicationCheck(String message) {
        this.message = message;
    }
}
