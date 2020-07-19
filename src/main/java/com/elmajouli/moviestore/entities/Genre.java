package com.elmajouli.moviestore.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity@Data@NoArgsConstructor
public class Genre {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String genre;
    @OneToMany(mappedBy = "genre", fetch =FetchType.LAZY )
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Movie> movies;
//    public Genre(String genre){
//        this.genre = genre;
//    }
}
