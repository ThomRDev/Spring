package com.springsecuritydemo.spsecurity.service.impl;

import com.springsecuritydemo.spsecurity.config.JwtService;
import com.springsecuritydemo.spsecurity.dto.AuthRequestDto;
import com.springsecuritydemo.spsecurity.dto.AuthResponseDto;
import com.springsecuritydemo.spsecurity.dto.RegisterRequestDto;
import com.springsecuritydemo.spsecurity.errors.UserAlreadyExistsException;
import com.springsecuritydemo.spsecurity.model.Role;
import com.springsecuritydemo.spsecurity.model._User;
import com.springsecuritydemo.spsecurity.repository.RoleRepository;
import com.springsecuritydemo.spsecurity.repository._UserRepository;
import com.springsecuritydemo.spsecurity.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;



@Service("authenticationServiceImpl")
public class AuthenticationServiceImpl implements AuthenticationService {

	@Autowired
	private _UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public AuthResponseDto register(RegisterRequestDto request) throws UserAlreadyExistsException{

		if (userRepository.findByEmail(request.getEmail()).isPresent()) {
			throw new UserAlreadyExistsException("A user with the same email already exists.");
		}

		Set<Role> roles = new HashSet<>();
		var userRole = this.roleRepository.findByName("ROLE_USER");
		var adminRole = this.roleRepository.findByName("ROLE_ADMIN");

		roles.add(userRole.get());
//		if(request.getEmail().equals("thomtwd@gmail.com")){
//			roles.add(userRole.get());
//			roles.add(adminRole.get());
//		}else{
//		}

		var user = _User
				.builder()
				.firstname(request.getFirstname())
				.lastname(request.getLastname())
				.email(request.getEmail())
				.password(this.passwordEncoder.encode(request.getPassword()))
				.roles(roles)
				.build();
		this.userRepository.save(user);
		var jwtToken = jwtService.generateToken(user);
		return AuthResponseDto.builder()
				.token(jwtToken)
				.message("Registrado con existo, bienvenido")
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
				.orElseThrow(() -> new UsernameNotFoundException("El usuario no existe"));

		var jwtToken = this.jwtService.generateToken(user);

		return AuthResponseDto.builder()
				.token(jwtToken)
				.message("Bienvenido")
				.build();
	}

}