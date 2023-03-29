package com.springsecuritydemo.spsecurity.controller;

import com.springsecuritydemo.spsecurity.dto.AuthRequestDto;
import com.springsecuritydemo.spsecurity.dto.AuthResponseDto;
import com.springsecuritydemo.spsecurity.dto.RegisterRequestDto;
import com.springsecuritydemo.spsecurity.service.AuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
	@Autowired
	private AuthenticationService service;

	@PostMapping("/register")
	public ResponseEntity<AuthResponseDto> register(
			@RequestBody RegisterRequestDto request
	) {
		return ResponseEntity.ok(service.register(request));
	}
	@PostMapping("/authenticate")
	public ResponseEntity<AuthResponseDto> authenticate(
			@RequestBody @Valid AuthRequestDto request
	) {
		return ResponseEntity.ok(service.authenticate(request));
	}
}