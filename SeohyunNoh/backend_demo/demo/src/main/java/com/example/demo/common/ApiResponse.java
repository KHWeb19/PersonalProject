package com.example.demo.common;

import java.time.LocalDate;

public class ApiResponse {
    private final boolean success;
    private final String message;

    public ApiResponse (boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getTimeStamp() {
        return LocalDate.now().toString();
    }
}
