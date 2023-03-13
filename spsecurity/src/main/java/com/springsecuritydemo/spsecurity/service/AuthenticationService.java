package com.springsecuritydemo.spsecurity.service;


import com.springsecuritydemo.spsecurity.dto.AuthRequestDto;
import com.springsecuritydemo.spsecurity.dto.AuthResponseDto;
import com.springsecuritydemo.spsecurity.dto.RegisterRequestDto;

public interface AuthenticationService {
	AuthResponseDto register(RegisterRequestDto request);
	AuthResponseDto authenticate(AuthRequestDto request);
}