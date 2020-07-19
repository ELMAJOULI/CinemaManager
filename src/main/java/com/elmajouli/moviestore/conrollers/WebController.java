package com.elmajouli.moviestore.conrollers;

import com.elmajouli.moviestore.entities.*;
import com.elmajouli.moviestore.model.RoomModel;
import com.elmajouli.moviestore.repositories.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@PreAuthorize("hasAnyRole('ADMIN')")
@RequestMapping("/secured")
@Controller
public class WebController {
    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;
    private final RoomRepository roomRepository;
    private final SeanceRepository seanceRepository;
    private final MovieProjectionRepository movieProjectionRepository;
    private final CityRepository cityRepository;
    private  final CinemaRepository cinemaRepository;
    private final PlaceRepository placeRepository;
    public WebController(MovieRepository movieRepository, GenreRepository genreRepository, RoomRepository roomRepository, SeanceRepository seanceRepository, MovieProjectionRepository movieProjectionRepository, CityRepository cityRepository, CinemaRepository cinemaRepository, PlaceRepository placeRepository) {
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
        this.roomRepository = roomRepository;
        this.seanceRepository = seanceRepository;
        this.movieProjectionRepository = movieProjectionRepository;
        this.cityRepository = cityRepository;
        this.cinemaRepository = cinemaRepository;
        this.placeRepository = placeRepository;
    }

    @GetMapping("/addMovie")
    public String getAddMovieForm(Model model) {

        model.addAttribute("genres",genreRepository.findAll()) ;
        return "addMovie";
    }
    @GetMapping("/updateMovie")
    public String getUpdateMovieForm(@RequestParam Long id, Model model) {

        model.addAttribute("prvMovie",movieRepository.findById(id).get());
        model.addAttribute("genres",genreRepository.findAll()) ;
        return "updateMovie";
    }
    @GetMapping("/addGenre")
    public String getAddGenre(){
        return "addGenre";
    }
    @PostMapping("/addGenre")
    public String addGenre(@RequestParam(name = "genreName") String genreName){
        Genre genre = new Genre();
        genre.setGenre(genreName);

        genreRepository.save(genre);
        return "redirect:/secured/addGenre";
    }
    @PostMapping("/addMovie")
    public String addMovie(@ModelAttribute Movie movie) {


         movieRepository.save(movie);
        return "redirect:/secured/addMovie";

    }
    @GetMapping("/addMovieProjection")
    public String getMovieProjectionAdmin(@RequestParam(required = false) Long id ,Model model){
        MovieProjection movieProjection = null;
        if (id != null) movieProjection = movieProjectionRepository.findById(id).get();
        model.addAttribute("movieProjection", movieProjection);
        model.addAttribute("rooms",roomRepository.findAll());
        model.addAttribute("movies",movieRepository.findAll());
        model.addAttribute("seances", seanceRepository.findAll());
        return "addMovieProjection";
    }
    @PostMapping("/addMovieProjection")
    public String addMovie(@ModelAttribute MovieProjection movieProj) {

        System.out.println(movieProj.getPrice());
        System.out.println(movieProj.getProjectionDate());
        System.out.println(movieProj.getSeance());
        System.out.println(movieProj.getMovie().getTitle());
        movieProjectionRepository.save(movieProj);
        return "redirect:/secured/addMovieProjection";
    }
    @GetMapping("/addCity")
    public String getAddCity(){
        return "addCity";
    }
    @PostMapping("/addCity")
    public String addCity(@ModelAttribute City city){
        System.out.println(city);
        cityRepository.save(city);
        return "redirect:/secured/addCity";
    }
    @GetMapping("/addCinema")
    public String getAddCinema(Model model){
        model.addAttribute("cities",cityRepository.findAll());
        return "addCinema";
    }
    @PostMapping("/addCinema")
    public String addCinema(@ModelAttribute Cinema cinema){


        cinemaRepository.save(cinema);
        return "redirect:/secured/addCinema";
    }
    @GetMapping("/addRoom")
    public String getAddRoom(Model model){
        model.addAttribute("cinemas",cinemaRepository.findAll());
        return "addRoom";
    }

    @PostMapping("/addRoom")
    public String addRoom(@ModelAttribute RoomModel roomModel){


        Room room = new Room();
        room.setName(roomModel.getName());
        room.setCinema(roomModel.getCinema());
        room = roomRepository.save(room);

        for (int i = 0; i < roomModel.getPlaceNumber(); i++) {
            Place place = new Place();
            place.setNumber(i+1);
            place.setRoom(room);
            placeRepository.save(place);
        }

        return "redirect:/secured/addRoom";
    }
    @GetMapping("/listMovie")
    public String getListMovie(Model  model){
        model.addAttribute("movies", movieRepository.findAll());
        return "listMovie";
    }
    @GetMapping("/deleteMovie")
    public String deleteMovie(@RequestParam Long id){
        movieRepository.deleteById(id);
        return "redirect:/secured/listMovie";
    }
    @GetMapping("/listCity")
    public String getListCity(Model  model){
        model.addAttribute("cities", cityRepository.findAll());
        return "listCity";
    }
    @GetMapping("/deleteCity")
    public String deleteCity(@RequestParam Long id){
        cityRepository.deleteById(id);
        return "redirect:/secured/listCity";
    }
    @GetMapping("/listCinema")
    public String getListCinema(Model model)
    {
        model.addAttribute("cinemas" , cinemaRepository.findAll());
        return "listCinema";
    }
    @GetMapping("/deleteCinema")
    public String deleteCinema(@RequestParam Long id){
        cinemaRepository.deleteById(id);
        return "redirect:/secured/listCinema";
    }
    @GetMapping("/listMovieProjection")
    public String getMovieProjection(@RequestParam(defaultValue = "0") int page
            ,@RequestParam(defaultValue = "10") int size
            ,@RequestParam(defaultValue = "-1") Double keyword,Model model){
        Page<MovieProjection> movieProjectionPages;
        if (keyword == -1)
            movieProjectionPages = movieProjectionRepository.findAll(PageRequest.of(page,size));
        else
            movieProjectionPages = movieProjectionRepository.findAllByPriceOrderByPrice(keyword,PageRequest.of(page,size));

        model.addAttribute("movieProjections",movieProjectionPages.getContent());
        model.addAttribute("currentPage",page);
        model.addAttribute("size",size);
        model.addAttribute("pagesNb",movieProjectionPages.getTotalPages());
        model.addAttribute("keyword",keyword);
        return "listMovieProjection";
    }
    @GetMapping("/deleteMovieProjection")
    public String deleteMovieProjection(@RequestParam Long id){
        movieProjectionRepository.deleteById(id);
        return "redirect:/secured/listMovieProjection";
    }

}
