package com.elmajouli.moviestore.repositories;

import com.elmajouli.moviestore.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,Long> {
    Optional<Users> findByName(String username);
}
