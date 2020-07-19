package com.elmajouli.moviestore.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Collection;
import java.util.Set;

@Entity
@Data@AllArgsConstructor@NoArgsConstructor@ToString
public class City {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @NotNull
    private String name;
    private Double longitude,latitude,altitude;
    private String image;
    @OneToMany(mappedBy = "city",cascade = CascadeType.PERSIST)
    private Collection<Cinema> cinema;
}
