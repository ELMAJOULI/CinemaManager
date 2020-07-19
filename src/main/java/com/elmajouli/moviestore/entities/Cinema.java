package com.elmajouli.moviestore.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.util.Collection;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor@NoArgsConstructor@ToString
public class Cinema {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String name;
    private  Integer roomsNumber;
    private double longitude,latitude,altitude;
    @OneToMany(mappedBy="cinema", fetch = FetchType.LAZY)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Room> rooms;
    @ManyToOne
    private City city;

}
