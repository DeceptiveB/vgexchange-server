package com.example.videogamexchange.controller;


import com.example.videogamexchange.payload.Videogame.VideogameResponse;
import com.example.videogamexchange.service.VideogameService;
import org.springframework.beans.factory.annotation.Autowired;
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

    //@GetMapping()
    @GetMapping(value = {"/videogame", "/videogame/"})
    public List<VideogameResponse> getVideosgame(
                                @RequestParam List<Integer> genre,
                                @RequestParam(value = "page", required = false) Integer page,
                                @RequestParam(value = "n", required = false) Integer nElements){
        if (nElements == null ){
            nElements = 5;
        }

        List<VideogameResponse> videogames = videogameService
                .getVideogamesByGenres(genre,
                        page,
                        nElements);
        videogames.forEach((element) -> System.out.println(element.genres()));
        //Videogame vg = videogameService.getVideogameByName("Red Dead Redemption");
        return videogames;
    }
}
