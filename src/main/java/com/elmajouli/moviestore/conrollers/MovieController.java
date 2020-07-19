package com.elmajouli.moviestore.conrollers;

import com.elmajouli.moviestore.entities.Cinema;
import com.elmajouli.moviestore.entities.Room;
import com.elmajouli.moviestore.entities.Ticket;
import com.elmajouli.moviestore.repositories.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MovieController {

    private final MovieRepository movieRepository ;
    private final GenreRepository genreRepository;
    private final RoomRepository roomRepository;
    private final CinemaRepository cinemaRepository;
    private final TicketRepository ticketRepository;
    public MovieController(MovieRepository movieRepository, GenreRepository genreRepository, RoomRepository roomRepository, CinemaRepository cinemaRepository, TicketRepository ticketRepository) {
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
        this.roomRepository = roomRepository;
        this.cinemaRepository = cinemaRepository;
        this.ticketRepository = ticketRepository;
    }
    @GetMapping("controller/cinemas/{id}/rooms")
    public List<Room> getRoomsWithMovieProjection(@PathVariable(name = "id") Long id){
        Cinema cinema =  cinemaRepository.findById(id).get();
        return  roomRepository.findAllByCinema(cinema);
    }
    @PostMapping("controller/purchase")
    public void purchaseTickets(@RequestBody ArrayList<Ticket> tickets){
     tickets.forEach(ticketRepository::save);

    }



//   // @GetMapping("movies/{page}/{size}")
//    public PaginationModel getMovies(@PathVariable(name = "page") int page,@PathVariable(name = "size") int size){
//        Page<Movie> moviePage = movieRepository.findAll(PageRequest.of(page, size));
//        PaginationModel Model = new PaginationModel();
//        Model.setTotalPages(moviePage.getTotalPages());
//        Model.setMovieList(moviePage.toList());
//        Model.setCurrentPage(page);
//        Model.setFilterBy("All Genre");
//        return Model;
//    }
//    // filtering by genre :
//    //@GetMapping("movies/{page}/{size}/{genre}")
//    public PaginationModel getMoviesByGenre(@PathVariable(name = "genre") String genre,@PathVariable(name = "page") int page,@PathVariable(name = "size") int size){
//        Page<Movie> moviePage = movieRepository.findMoviesByGenre_Genre(genre,PageRequest.of(page, size));
//        PaginationModel Model = new PaginationModel();
//        Model.setTotalPages(moviePage.getTotalPages());
//        Model.setMovieList(moviePage.toList());
//        Model.setCurrentPage(page);
//        Model.setFilterBy(genre);
//        return Model;
//    }
//
//    @GetMapping("allgenres")
//    public List<Genre> getGenres(){
//        return genreRepository.findAll();
//    }
//
//   // @GetMapping("movie/{id}")
//    public Movie getMovie(@PathVariable("id") Long id){
//
//        return movieRepository.findById(id).orElse(null);
//    }

//    @PatchMapping("movie/rate/{id}/{number}")
//    public Movie patchRateMovie(@PathVariable("id") Long id, @PathVariable("number") Double number){
//        Movie movieUpdated = movieRepository.findById(id).orElse(null);
//        if(movieUpdated != null){
//            movieUpdated.setPersonRated(movieUpdated.getPersonRated()+1);
//            movieUpdated.setRate(movieUpdated.getRate()+number);
//            movieRepository.save(movieUpdated);
//        }
//        else return null;
//         return movieUpdated;
//    }
//

//    @PostMapping("movies")
//    public Movie addMovie(@RequestBody Movie movie){
//        System.out.println(movie);
//        movieRepository.save(movie);
//        return movie;
//    }
//    @DeleteMapping("movie/{id}")
//    public Movie removeMovie(@PathVariable("id") Long id){
//        Movie movie = movieRepository.findById(id).orElse(null);
//        if (movie != null)
//        movieRepository.deleteById(id);
//        else return null;
//
//        return movie;
//    }
}
