package com.example.videogamexchange.service;

import com.example.videogamexchange.mapper.Videogame.ListVideogameMapper;
import com.example.videogamexchange.mapper.Videogame.VideogameMapper;
import com.example.videogamexchange.model.Genre;
import com.example.videogamexchange.model.Videogame;
import com.example.videogamexchange.payload.Videogame.ListVideogameResponse;
import com.example.videogamexchange.payload.Videogame.VideogameResponse;
import com.example.videogamexchange.repository.VideogameRepo;
import com.example.videogamexchange.specification.VideogameSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideogameService {

    @Autowired
    private VideogameMapper videogameMapper;

    @Autowired
    private ListVideogameMapper listVideogameMapper;
    @Autowired
    private VideogameRepo videogameRepo;


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
}