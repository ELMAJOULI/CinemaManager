package com.elmajouli.moviestore.entities;

import org.springframework.data.rest.core.config.Projection;

import java.util.Collection;

@Projection(name = "roomproj",types = {Room.class})
public interface RoomProjection {
    Long getId();
   // Collection<Seat> getSeats();
    Collection<MovieProjection> getMovieProjections();
}
