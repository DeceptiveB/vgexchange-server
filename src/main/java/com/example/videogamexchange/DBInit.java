package com.example.videogamexchange;

import com.example.videogamexchange.model.Developer;
import com.example.videogamexchange.model.Genre;
import com.example.videogamexchange.model.Post;
import com.example.videogamexchange.model.Videogame;
import com.example.videogamexchange.model.user.AppUser;
import com.example.videogamexchange.repository.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DBInit {
    @Autowired
    private AppUserRepo appUserRepo;

    @Autowired
    private VideogameRepo vgRepo;

    @Autowired
    private GenreRepo genreRepo;

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private DeveloperRepo developerRepo;

    @PostConstruct
    public void postConstruct(){
        Developer rockstar = developerRepo.save(new Developer("Rockstar"));
        Genre action = genreRepo.save(new Genre("Action"));
        Genre adventure = genreRepo.save(new Genre("Adventure"));
        Videogame gta5 = vgRepo.save(new Videogame("Grand Theft Auto", "Free world game", LocalDate.of(2013, 9, 17), rockstar, List.of(action, adventure)));
        Videogame rdr = vgRepo.save(new Videogame("Red Dead Redemption", "Free world game but cowboys", LocalDate.of(2010, 5, 21), rockstar, List.of(action, adventure)));
        AppUser user = appUserRepo.save(new AppUser("deceptiveb", "Bernardo Dom", "ddrake@gmail.com", "deceptiveb", "998112232"));
        Post post = postRepo.save(new Post("This game sucks", user, gta5));
    }
}
