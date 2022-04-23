package com.example.demo.request.search;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChangePwRequest {
    private String id;
    private String pw;

    public ChangePwRequest(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }
}
