package com.example.demo.request.search;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SearchIdRequest {
    private String name;
    private Integer birth;

    public SearchIdRequest(String name, Integer birth) {
        this.name = name;
        this.birth = birth;
    }
}
