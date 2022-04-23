package com.example.demo.controller.session;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
}
