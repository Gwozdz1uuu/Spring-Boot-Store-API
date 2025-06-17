package com.gwozdz1uu.store.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class LoginResponse  {
    private Jwt accessToken;
    private Jwt refreshToken;
}
