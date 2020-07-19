package com.elmajouli.moviestore.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Entity
@Data@AllArgsConstructor@NoArgsConstructor@ToString
public class MovieProjection {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(value = TemporalType.DATE)
    @DateTimeFormat(pattern = "yyy-mm-dd")
    private Date projectionDate;
    private Double price;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Room room;
    @ManyToOne
    private Movie movie;
    @OneToMany(mappedBy = "movieProjection", fetch = FetchType.LAZY)
    private Collection<Ticket> tickets;

    @ManyToOne
    private Seance seance;
}
