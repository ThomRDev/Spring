package com.thomcompany.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    // esta clase tiene el metodo logout que es utilizado para realizar la operacion de cierre de session
    // para quitarlo del SecurityContextHolder

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http
            .csrf().disable()
            .authorizeHttpRequests()
            .requestMatchers("/api/v1/auth/**")
                .permitAll()
            .anyRequest()
                .authenticated()
            .and()
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authenticationProvider(this.authenticationProvider)
            .addFilterBefore(this.jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build(); // Devuelve la cadena de filtros de seguridad construida.
    }
}
