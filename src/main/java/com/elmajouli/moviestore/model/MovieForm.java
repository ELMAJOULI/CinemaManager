package com.elmajouli.moviestore.model;

import lombok.*;

@Getter@Setter@ToString@AllArgsConstructor@NoArgsConstructor
public class MovieForm {
    private String title;
    private String poster;
    private Long genre;
    private String details;
    private double  duration;
    private String director;
    private String releaseDate;
}
