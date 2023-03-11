package com.thomcompany.springsecurity.config;

import com.thomcompany.springsecurity.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ApplicationConfig {

    @Autowired
    private UserRepository userRepository;


    // este bean me servira para reemplazar la que ya viene por defecto de spring
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

    // este bean reemplazra al que viene por defecto y es la base para todos los proveedores de authenticacion
    // en spring security
    @Bean
    public AuthenticationProvider authenticationProvider(){

        // es una implementacion de AuthenticationProvider, se utiliza para validar las credenciales de
        // inicio de sesion
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        // definimos que UserDetailsService vamos a utilizar para poder recuperar los detalles de usuario
        // durante la autenticacion
        authProvider.setUserDetailsService(userDetailsService());

        // tambien que PasswordEncoder vamos a utilizar para la validacion de contraseñas
        authProvider.setPasswordEncoder(passwordEncoder());

        // todas estas asignaciones fueron sobreescritas por nosotros mismos userDetailsService() y passwordEncoder()
        return authProvider;
    }

        // AuthenticationManager sirve para un punto de entrada para todas las solicitudes de autenticacion
        // e encarga de autenticar las solicitudes de autenticación entrantes utilizando diferentes
        // proveedores de autenticación configurados en la aplicación
        @Bean
        public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
            return config.getAuthenticationManager();
        }

    // aqui sobre escribimos en PasswordEncoder y utilizaremos  BCryptPasswordEncoder
    // ya que BCryptPasswordEncoder es una implementacion de PasswordEncoder
    // y utilizar el algoritmo hashing bcrypt para cifrar contraseñas de usuario
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
