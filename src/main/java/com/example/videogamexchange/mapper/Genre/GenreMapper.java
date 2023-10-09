package com.example.videogamexchange.mapper.Genre;

import com.example.videogamexchange.model.Genre;
import com.example.videogamexchange.payload.Genre.GenreResponse;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class GenreMapper implements Function<Genre, GenreResponse> {
    @Override
    public GenreResponse apply(Genre genre) {
        return new GenreResponse(
                genre.getId(),
                genre.getName()
        );
    }
}
