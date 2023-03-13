package com.springsecuritydemo.spsecurity.config;

import com.springsecuritydemo.spsecurity.model.Role;
import com.springsecuritydemo.spsecurity.model.RoleName;
import com.springsecuritydemo.spsecurity.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class RoleConfig {
	@Bean
	CommandLineRunner commandLineRunner(RoleRepository repository){
		return args -> {
			Set<Role> roles = new HashSet<>();

			Role userRole = Role.builder().name(RoleName.ROLE_USER).build();
			Role adminRole = Role.builder().name(RoleName.ROLE_ADMIN).build();
			roles.add(userRole);
			roles.add(adminRole);
			repository.saveAll(roles);
		};
	}
}
