package com.example.videogamexchange.mapper.Videogame;

import com.example.videogamexchange.model.Genre;
import com.example.videogamexchange.model.Videogame;
import com.example.videogamexchange.payload.Videogame.VideogameResponse;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class VideogameResponseMapper implements Function<Videogame, VideogameResponse> {
    @Override
    public VideogameResponse apply(Videogame videogame) {
        return new VideogameResponse(
                videogame.getId(),
                videogame.getName(),
                videogame.getDeveloper().getName(),
                videogame.getReleaseDate(),
                videogame.getArgument(),
                videogame.getGenres()
                        .stream()
                        .map(Genre::getName)
                        .collect(Collectors.toList())
        );
    }
}
