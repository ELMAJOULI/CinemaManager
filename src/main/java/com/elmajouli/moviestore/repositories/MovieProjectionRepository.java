package com.elmajouli.moviestore.repositories;

import com.elmajouli.moviestore.entities.MovieProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin("*")
public interface MovieProjectionRepository extends JpaRepository<MovieProjection,Long> {

}
