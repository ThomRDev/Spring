package com.thomcompany.springsecurity.auth.controller;

import com.thomcompany.springsecurity.auth.dto.AuthRequestDto;
import com.thomcompany.springsecurity.auth.dto.AuthResponseDto;
import com.thomcompany.springsecurity.auth.dto.RegisterRequestDto;
import com.thomcompany.springsecurity.auth.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    @Autowired
    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthResponseDto> register(
            @RequestBody RegisterRequestDto request
    ) {
        return ResponseEntity.ok(service.register(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponseDto> authenticate(
            @RequestBody AuthRequestDto request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}
