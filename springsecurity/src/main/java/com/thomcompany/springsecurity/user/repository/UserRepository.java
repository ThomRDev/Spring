package com.thomcompany.springsecurity.user.repository;


import com.thomcompany.springsecurity.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("SELECT _u FROM _user _u WHERE _u.email = ?1")
    Optional<User> findByEmail(String email);

}
