package com.sof.amh.controller;

import com.sof.amh.security.JwtIssuer;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sof.amh.model.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class AuthController {

    private final JwtIssuer jwtIssuer;

    @PostMapping("/auth/login")
    public LoginResponse login(@RequestBody @Validated LoginRequest loginRequest) {
        var token = jwtIssuer.issue(1, loginRequest.getEmail(), List.of("USER"));

        return LoginResponse.builder()
                .accessToken(token)
                .build();
    }
}
