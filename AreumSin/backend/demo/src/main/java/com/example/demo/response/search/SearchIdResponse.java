package com.example.demo.response.search;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SearchIdResponse {
    private String id;

    public SearchIdResponse(String id) {
        this.id = id;
    }
}
