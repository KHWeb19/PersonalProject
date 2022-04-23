package com.example.demo.request.search;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchPwRequest {
    private String name;
    private String id;

    public SearchPwRequest(String name, String id) {
        this.name = name;
        this.id = id;
    }
}
