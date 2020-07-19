package com.elmajouli.moviestore.initialization;

import com.elmajouli.moviestore.entities.*;
import com.elmajouli.moviestore.repositories.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Random;
import java.util.stream.Stream;

@Service@Transactional
public class CinemaInitService implements ICinemaInitService {
private final CinemaRepository cinemaRepository;
private final RoomRepository roomRepository;
private final PlaceRepository placeRepository;
private final CityRepository cityRepository;
private final MovieRepository  movieRepository;
private final SeanceRepository seanceRepository;
private final MovieProjectionRepository movieProjectionRepository;
private final TicketRepository ticketRepository;
    public CinemaInitService(CinemaRepository cinemaRepository, RoomRepository roomRepository, PlaceRepository placeRepository, CityRepository cityRepository, MovieRepository movieRepository, SeanceRepository seanceRepository, MovieProjectionRepository movieProjectionRepository, TicketRepository ticketRepository) {
        this.cinemaRepository = cinemaRepository;
        this.roomRepository = roomRepository;
        this.placeRepository = placeRepository;
        this.movieRepository = movieRepository;
        this.cityRepository = cityRepository;
        this.seanceRepository = seanceRepository;
        this.movieProjectionRepository = movieProjectionRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    public void initCities() {

    }

    @Override
    public void initCinemas() {
        cityRepository.findAll().forEach(city -> {
            Stream.of("MEGARAMA","IMAX","CHARAZAD").forEach( name -> {
                Cinema cinema  = new Cinema();
                cinema.setName(name);
                cinema.setCity(city);
                cinema.setRoomsNumber((int)(3+Math.random()*10));
                cinemaRepository.save(cinema);
            });
        });
    }

    @Override
    public void initRooms() {
        cinemaRepository.findAll().forEach(cinema -> {
            for(int i = 0  ; i < cinema.getRoomsNumber()  ; i++){
                Room room  = new  Room();
                room.setCinema(cinema);
                room.setName("Room "+(i+1));
                roomRepository.save(room);
            }
        });
    }

    @Override
    public void initPlaces() {
roomRepository.findAll().forEach(room -> {
    for (int i = 0; i < 18; i++) {
        Place place = new Place();
        place.setNumber(i+1);
        place.setRoom(room);
        placeRepository.save(place);
    }
});
    }

    @Override
    public void initSeances() {

    }

    @Override
    public void initGenres() {

    }

    @Override
    public void initMovies() {

    }

    @Override
    public void initMovieProjections() {
        double[] prices =  new double[] { 30,55,60,75,99};
        cityRepository.findAll().forEach(city -> {
            city.getCinema().forEach(cinema -> {
                cinema.getRooms().forEach(room ->
                {
                  Movie movie =  movieRepository.findAll().get(new Random().nextInt(movieRepository.findAll().size()));
                  seanceRepository.findAll().forEach(seance -> {
                      MovieProjection movieProjection = new MovieProjection();
                      movieProjection.setMovie(movie);
                      movieProjection.setPrice(prices[new Random().nextInt(prices.length)]);
                      movieProjection.setRoom(room);
                      movieProjection.setSeance(seance);
                      movieProjection.setProjectionDate(new Date());
                      movieProjectionRepository.save(movieProjection);
                  });
                });
            });
        });
    }

    @Override
    public void initTickets() {
        movieProjectionRepository.findAll().forEach(movieProjection -> {
            movieProjection.getRoom().getPlaces().forEach(place -> {
                Ticket ticket = new Ticket();
                ticket.setPlace(place);
                ticket.setPrice(movieProjection.getPrice());
                ticket.setMovieProjection(movieProjection);
                ticket.setReserved(false);
                ticketRepository.save(ticket);
            });
        });
    }
}
