package com.example.videogamexchange.service;

import com.example.videogamexchange.mapper.Genre.GenreMapper;
import com.example.videogamexchange.payload.Genre.GenreResponse;
import com.example.videogamexchange.repository.GenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GenreService {
    @Autowired
    private GenreRepo genreRepo;

    @Autowired
    private GenreMapper genreMapper;

    public List<GenreResponse> getAllGenres(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return genreRepo.findAll(pageable)
                .stream()
                .map(genreMapper)
                .collect(Collectors.toList());
    }
}
