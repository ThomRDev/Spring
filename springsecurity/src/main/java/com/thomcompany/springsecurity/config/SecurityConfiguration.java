package com.thomcompany.springsecurity.config;

import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class SecurityConfiguration {

    @Autowired
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Autowired
    private final AuthenticationProvider authenticationProvider;

    // esta clase tiene el metodo logout que es utilizado para realizar la operacion de cierre de session
    // para quitarlo del SecurityContextHolder
    @Autowired
    private final LogoutHandler logoutHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http
//        Habilita la configuración del control de acceso a recursos compartidos en origen (CORS).
            .cors().and()
            .csrf().disable() // Deshabilita la protección CSRF.
            // permite configurar la autorización de las solicitudes HTTP.
            .authorizeHttpRequests()
//        Permite el acceso a la ruta "/api/v1/auth" sin necesidad de autenticación.
            .requestMatchers("/api/v1/auth/**")
                .permitAll()
            // Requiere autenticación para todas las demás solicitudes HTTP.
            .anyRequest()
                .authenticated()
            .and()
//        Establece la política de creación de sesiones como "stateless" para asegurar aplicaciones sin estado.
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
//                Agrega un proveedor de autenticación personalizado.
            .authenticationProvider(authenticationProvider)
//                Agrega el filtro personalizado "jwtAuthenticationFilter" antes del filtro "UsernamePasswordAuthenticationFilter".
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
//                Configura el logout URL y los handlers para el evento logout.
            .logout()
            .logoutUrl("/api/v1/auth/logout")
            .addLogoutHandler(logoutHandler)
            .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext());
        return http.build(); // Devuelve la cadena de filtros de seguridad construida.
    }
}
