package com.example.videogamexchange.payload.Videogame;

import com.example.videogamexchange.model.Developer;

import java.time.LocalDate;
import java.util.List;

public record VideogameRequest (
        String name,

        String developer,

        LocalDate releaseDate,

        String argument,

        List<Integer> genres
){
}
