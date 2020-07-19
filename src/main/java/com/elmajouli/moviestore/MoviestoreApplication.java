package com.elmajouli.moviestore;


import com.elmajouli.moviestore.entities.Role;
import com.elmajouli.moviestore.entities.Users;
import com.elmajouli.moviestore.initialization.ICinemaInitService;
import com.elmajouli.moviestore.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;


@SpringBootApplication
public class MoviestoreApplication implements CommandLineRunner  {
 @Autowired
 private ICinemaInitService cinemaInitService;
@Autowired
private UsersRepository usersRepository;

    public static void main(String[] args) {
        SpringApplication.run(MoviestoreApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
//    cinemaInitService.initCinemas();
//    cinemaInitService.initRooms();
//    cinemaInitService.initPlaces();
//    cinemaInitService.initMovieProjections();
//    cinemaInitService.initTickets();
//        Role role = new Role();
//        role.setRole("ADMIN");
//        ArrayList<Role> roles = new ArrayList<>();
//        roles.add(role);
//        Users users = new Users();
//        users.setEmail("abdelwahed@gmail.com");
//        users.setName("abdelwahed");
//        users.setLastName("elmajouli");
//        users.setPassword("123456");
//        users.setRoles(roles);
//        usersRepository.save(users);
    }
}
