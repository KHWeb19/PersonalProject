package com.example.backend.controller.member.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class SignInForm {

    private String userId;
    private String password;

    public SignInRequest toSignInRequest() {
        return new SignInRequest(userId, password);
    }
}
