package com.example.videogamexchange.controller;

import com.example.videogamexchange.payload.Genre.GenreResponse;
import com.example.videogamexchange.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/genres")
public class GenreController {

    @Autowired
    private GenreService genreService;

    @GetMapping
    public ResponseEntity<List<GenreResponse>> getAllGenres(
            @RequestParam(
                    value = "page",
                    required = false,
                    defaultValue = "0") Integer page,
            @RequestParam(
                    value = "size",
                    required = false,
                    defaultValue = "5") Integer size
    ) {
        return ResponseEntity.ok().body(genreService.getAllGenres(page, size));
    }
}
