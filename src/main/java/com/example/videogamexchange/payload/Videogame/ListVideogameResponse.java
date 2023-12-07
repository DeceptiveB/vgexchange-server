package com.example.videogamexchange.payload.Videogame;

import java.util.List;

public record ListVideogameResponse(
        String name,
        String developer,

        List<String> genres
) {
}
