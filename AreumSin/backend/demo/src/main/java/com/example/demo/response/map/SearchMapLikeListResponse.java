package com.example.demo.response.map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchMapLikeListResponse {
    private String title;

    public SearchMapLikeListResponse(String title) {
        this.title = title;
    }
}
