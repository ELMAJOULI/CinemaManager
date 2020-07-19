package com.elmajouli.moviestore.repositories;

import com.elmajouli.moviestore.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:3000")
public interface CityRepository extends JpaRepository<City,Long> {
}
