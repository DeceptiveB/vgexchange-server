package com.example.videogamexchange.service;

import com.example.videogamexchange.exception.ResourceNotFoundException;
import com.example.videogamexchange.mapper.Videogame.ListVideogameMapper;
import com.example.videogamexchange.mapper.Videogame.VideogameResponseMapper;
import com.example.videogamexchange.model.Developer;
import com.example.videogamexchange.model.Genre;
import com.example.videogamexchange.model.Videogame;
import com.example.videogamexchange.payload.Videogame.ListVideogameResponse;
import com.example.videogamexchange.payload.Videogame.VideogameRequest;
import com.example.videogamexchange.repository.DeveloperRepo;
import com.example.videogamexchange.repository.GenreRepo;
import com.example.videogamexchange.repository.VideogameRepo;
import com.example.videogamexchange.specification.VideogameSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideogameService {

    @Autowired
    private VideogameResponseMapper videogameMapper;

    @Autowired
    private ListVideogameMapper listVideogameMapper;
    @Autowired
    private VideogameRepo videogameRepo;

    @Autowired
    private GenreRepo genreRepo;

    @Autowired
    private DeveloperRepo developerRepo;


    public List<ListVideogameResponse> getVideogames(int page,
                                                     int size,
                                                     List<Integer> genres,
                                                     String developer){
        Specification<Videogame> spec = Specification.where(null);
        System.out.println(genres);
        if(genres != null){
            spec = spec.and(VideogameSpecification.isGenre(genres));
        }
        if (developer != null){
            spec = spec.and(VideogameSpecification.hasDeveloper(developer));
        }
        Pageable pageable = PageRequest.of(page, size);
        return videogameRepo
                .findAll(spec, pageable)
                .stream()
                .map(listVideogameMapper)
                .collect(Collectors.toList());
    }
    public List<ListVideogameResponse> getVideogamesByGenres(
                                                List<Integer> genres,
                                                int page,
                                                int nElements) {
        Pageable pageable = PageRequest.of(page, nElements);
        return videogameRepo.
                findByGenresIdIn(genres, pageable)
                .stream()
                .map(listVideogameMapper)
                .collect(Collectors.toList());
    }

    public Videogame getVideogameByName(String name){
        return videogameRepo.findByName(name).orElseThrow();
    }


    public Videogame saveVideogame(VideogameRequest videogameRequest) {
        List<Genre> genres = new ArrayList<>();
        Developer dev = null;
        if (videogameRequest.genres() != null){

            for (Integer id : videogameRequest.genres()
            ) {
                Genre genre = genreRepo.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("genre", "id", id));
            }
        }

        if (videogameRequest.developer() != null){
            dev = developerRepo.findByName(videogameRequest.developer())
                    .orElseThrow(() -> new ResourceNotFoundException("developer", "name", videogameRequest.developer()));
        }
        Videogame vg = new Videogame(
                videogameRequest.name(),
                videogameRequest.argument(),
                videogameRequest.releaseDate(),
                dev,
                genres
        );

        return vg;
    }
}