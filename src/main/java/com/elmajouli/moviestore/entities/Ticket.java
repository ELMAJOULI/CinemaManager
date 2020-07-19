package com.elmajouli.moviestore.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data@AllArgsConstructor@NoArgsConstructor@ToString
public class Ticket {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clientName;
    private Double price;
    private Long codePayment;
    private Boolean reserved;
    @ManyToOne
    private Place place;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private MovieProjection movieProjection;
}
