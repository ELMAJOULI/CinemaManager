package com.elmajouli.moviestore.repositories;

import com.elmajouli.moviestore.entities.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface MovieRepository  extends JpaRepository<Movie,Long> {
    Page<Movie> findMoviesByGenre_Genre(String genre, Pageable page);
}
