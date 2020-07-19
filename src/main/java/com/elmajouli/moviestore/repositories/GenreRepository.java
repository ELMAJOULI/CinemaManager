package com.elmajouli.moviestore.repositories;

import com.elmajouli.moviestore.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface GenreRepository extends JpaRepository<Genre,Long> {
}
