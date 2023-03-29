package com.thomcompany.springsecurity.auth.service.impl;

import com.thomcompany.springsecurity.auth.dto.AuthRequestDto;
import com.thomcompany.springsecurity.auth.dto.AuthResponseDto;
import com.thomcompany.springsecurity.auth.dto.RegisterRequestDto;
import com.thomcompany.springsecurity.auth.service.AuthenticationService;
import com.thomcompany.springsecurity.config.JwtService;
import com.thomcompany.springsecurity.user.domain.Role;
import com.thomcompany.springsecurity.user.domain.User;
import com.thomcompany.springsecurity.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("authenticationServiceImpl")
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public AuthResponseDto register(RegisterRequestDto request) {

        var user = User
                .builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(this.passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        var savedUser = this.userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthResponseDto.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public AuthResponseDto authenticate(AuthRequestDto request) {

        this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        var user = this.userRepository.findByEmail(request.getEmail())
                .orElseThrow();

        var jwtToken = this.jwtService.generateToken(user);

        return AuthResponseDto.builder()
                .token(jwtToken)
                .build();
    }

    @Override
    public void saveUserToken(User user, String jwtToken) {

    }

    @Override
    public void revokeAllUserTokens(User user) {

    }
}
