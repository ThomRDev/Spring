package com.thomcompany.springsecurity.auth.service.impl;

import com.thomcompany.springsecurity.auth.dto.AuthRequestDto;
import com.thomcompany.springsecurity.auth.dto.AuthResponseDto;
import com.thomcompany.springsecurity.auth.dto.RegisterRequestDto;
import com.thomcompany.springsecurity.auth.service.AuthenticationService;
import com.thomcompany.springsecurity.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service("authenticationServiceImpl")
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    @Override
    public AuthResponseDto register(RegisterRequestDto request) {
        return null;
    }

    @Override
    public AuthResponseDto authenticate(AuthRequestDto request) {
        return null;
    }

    @Override
    public void saveUserToken(User user, String jwtToken) {

    }

    @Override
    public void revokeAllUserTokens(User user) {

    }
}
