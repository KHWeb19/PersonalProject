package com.example.demo.response;


import lombok.Data;

@Data
public class DuplicationCheck {
    private String message;

    public DuplicationCheck(String message) {
        this.message = message;
    }
}
