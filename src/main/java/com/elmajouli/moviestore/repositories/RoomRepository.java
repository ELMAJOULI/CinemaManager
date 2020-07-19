package com.elmajouli.moviestore.repositories;

import com.elmajouli.moviestore.entities.Cinema;
import com.elmajouli.moviestore.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface RoomRepository extends JpaRepository<Room,Long> {
    List<Room> findAllByCinema(Cinema cinema);
}
