package com.thomcompany.springsecurity.config;

import com.thomcompany.springsecurity.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfig {

    @Autowired
    private final UserRepository userRepository;


    @Bean
    public UserDetailsService userDetailsService(){
        return username -> {
            return userRepository
                    .findByEmail(username)
                    .orElseThrow(
                            () -> new UsernameNotFoundException("User not found")
                    );
        };
    }

}
