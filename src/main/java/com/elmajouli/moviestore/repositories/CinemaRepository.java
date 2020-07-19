package com.elmajouli.moviestore.repositories;

import com.elmajouli.moviestore.entities.Cinema;
import com.elmajouli.moviestore.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:3000")
public interface CinemaRepository extends JpaRepository<Cinema,Long> {
}
