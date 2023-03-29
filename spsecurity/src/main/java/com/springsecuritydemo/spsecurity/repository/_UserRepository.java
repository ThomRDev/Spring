package com.springsecuritydemo.spsecurity.repository;

import com.springsecuritydemo.spsecurity.model._User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  _UserRepository extends JpaRepository<_User, Long> {
	Optional<_User> findByEmail(String email);
}