package com.thomcompany.springsecurity.auth.service;

import com.thomcompany.springsecurity.auth.dto.AuthRequestDto;
import com.thomcompany.springsecurity.auth.dto.AuthResponseDto;
import com.thomcompany.springsecurity.auth.dto.RegisterRequestDto;
import com.thomcompany.springsecurity.user.domain.User;

public interface AuthenticationService {
    AuthResponseDto register(RegisterRequestDto request);
    AuthResponseDto authenticate(AuthRequestDto request);
    void saveUserToken(User user, String jwtToken);
    void revokeAllUserTokens(User user);
}
