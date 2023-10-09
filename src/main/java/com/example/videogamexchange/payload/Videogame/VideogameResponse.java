package com.example.videogamexchange.payload.Videogame;

import java.time.LocalDate;
import java.util.List;

public record VideogameResponse (
        Integer id,
        String name,

        String developer,

        LocalDate releaseDate,

        String argument,

        List<String> genres
){
}