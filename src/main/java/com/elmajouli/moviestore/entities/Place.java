package com.elmajouli.moviestore.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Set;
@Entity
@Data
@Getter@Setter
@AllArgsConstructor@NoArgsConstructor@ToString
public class Place {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Integer number;
    private double longitude,latitude,altitude;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Room room;
    @OneToMany(mappedBy="place")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Set<Ticket> tickets;
}
