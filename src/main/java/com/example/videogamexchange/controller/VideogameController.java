package com.example.videogamexchange.controller;


import com.example.videogamexchange.payload.Videogame.ListVideogameResponse;
import com.example.videogamexchange.payload.Videogame.VideogameResponse;
import com.example.videogamexchange.service.VideogameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/videogames")
public class VideogameController {

    @Autowired
    private VideogameService videogameService;

    //@GetMapping()Z
    @GetMapping("/videogame")
    public ResponseEntity<List<ListVideogameResponse>> getVideosgame(
                                @RequestParam(
                                        value = "developer",
                                        required = false) String developer,
                                @RequestParam(
                                        value = "genres",
                                        required = false) List<Integer> genres,
                                @RequestParam(value = "page",
                                        required = false,
                                        defaultValue = "0") Integer page,
                                @RequestParam(value = "size",
                                        required = false,
                                        defaultValue = "5") Integer size){
        /*if (nElements == null ){
            nElements = 5;
        }*/
        System.out.println(genres);

        System.out.println(page);
        System.out.println(size);

        List<ListVideogameResponse> videogames = videogameService
                .getVideogames(
                        page,
                        size,
                        genres,
                        developer);
        return ResponseEntity.ok().body(videogames);
    }

    //@GetMapping("/videogame")
    /*public ResponseEntity<List<ListVideogameResponse>>  getVideogameByGenre(
            @RequestParam(
                    value = "genre",
                    required = false) List<Integer> genres,
            @RequestParam(value = "page",
                    required = false, defaultValue = "0") Integer page,
            @RequestParam(value = "size",
                    required = false,
                    defaultValue = "5") Integer size
    ){
        return ResponseEntity.ok().body(videogameService.getVideogamesByGenres(genres, page, size));
    }*/
}
