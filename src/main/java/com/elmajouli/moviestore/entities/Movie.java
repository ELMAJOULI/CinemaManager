package com.elmajouli.moviestore.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Entity@Data@ToString@AllArgsConstructor@NoArgsConstructor
public class Movie {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @NotNull
    private String title;
    @NotNull
    private String poster;
    @NotNull
    @ManyToOne
    private Genre genre;
    @Lob
    private String details;
    @NotNull
    private double duration;
    private Double rate;
    private int personRated;

    private String director;
    @DateTimeFormat(pattern = "yyy-mm-dd")
    @Temporal(TemporalType.DATE)
    private Date releaseDate;
    @OneToMany(mappedBy = "movie")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<MovieProjection> movieProjections;
}
