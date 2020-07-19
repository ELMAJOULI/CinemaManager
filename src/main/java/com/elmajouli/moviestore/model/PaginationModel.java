package com.elmajouli.moviestore.model;

import com.elmajouli.moviestore.entities.Movie;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter @Setter
public class PaginationModel {
    private List<Movie> movieList;
    private String filterBy;
    private int currentPage;
    private int totalPages;

}
