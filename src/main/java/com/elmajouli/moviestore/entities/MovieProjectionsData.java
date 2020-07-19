package com.elmajouli.moviestore.entities;

import org.springframework.data.rest.core.config.Projection;

import java.util.Collection;
import java.util.Date;

//@Projection(name = "proj",types = {MovieProjection.class})
public interface MovieProjectionsData {
    Long getId();
    Date getProjectionDate();
    Double getPrice();
    Room getRoom();
    Movie getMovie();
    Seance getSeance();
    Collection<Ticket> getTickets();
}
