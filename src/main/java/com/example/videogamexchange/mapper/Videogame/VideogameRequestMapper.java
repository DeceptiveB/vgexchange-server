package com.example.videogamexchange.mapper.Videogame;

import com.example.videogamexchange.model.Genre;
import com.example.videogamexchange.model.Videogame;
import com.example.videogamexchange.payload.Videogame.VideogameRequest;
import com.example.videogamexchange.payload.Videogame.VideogameResponse;

import java.util.function.Function;
import java.util.stream.Collectors;

public class VideogameRequestMapper implements Function<VideogameRequest, Videogame> {

    @Override
    public Videogame apply(VideogameRequest videogame) {
        return new Videogame(
                videogame.name(),
                videogame.argument(),
                videogame.developer(),
                videogame.releaseDate(),
                videogame.genres()
                        .stream()
                        .map(Genre::getName)
                        .collect(Collectors.toList())
        );
    }
}
