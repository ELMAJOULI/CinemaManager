package com.elmajouli.moviestore.model;

import com.elmajouli.moviestore.entities.Movie;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.List;

@Setter@Getter
public class GenreModel {
    private String genre;
    private List<Movie> movies;
}
