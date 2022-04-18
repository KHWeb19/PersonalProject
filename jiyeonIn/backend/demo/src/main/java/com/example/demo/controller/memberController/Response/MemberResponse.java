package com.example.demo.controller.memberController.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberResponse {
    private String userId;
    private String password;
    private String userName;

}
