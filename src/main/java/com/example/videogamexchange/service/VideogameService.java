package com.example.videogamexchange.service;

import com.example.videogamexchange.mapper.Videogame.VideogameMapper;
import com.example.videogamexchange.model.Videogame;
import com.example.videogamexchange.payload.Videogame.VideogameResponse;
import com.example.videogamexchange.repository.VideogameRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VideogameService {

    private final VideogameMapper videogameMapper;
    @Autowired
    private VideogameRepo videogameRepo;

    public VideogameService(
            VideogameMapper videogameMapper
    ){
        this.videogameMapper = videogameMapper;
    }
    public List<VideogameResponse> getVideogamesByGenres(
                                                List<Integer> genres,
                                                int page,
                                                int nElements) {
        Pageable pageable = PageRequest.of(page, nElements);
        return videogameRepo.
                findByGenresIdIn(genres, pageable)
                .stream()
                .map(videogameMapper)
                .collect(Collectors.toList());
    }

    public Videogame getVideogameByName(String name){
        return videogameRepo.findByName(name).orElseThrow();
    }
}