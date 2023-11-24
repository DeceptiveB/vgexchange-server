package com.example.videogamexchange.mapper.Videogame;

import com.example.videogamexchange.model.Genre;
import com.example.videogamexchange.model.Videogame;
import com.example.videogamexchange.payload.Videogame.ListVideogameResponse;
import com.example.videogamexchange.payload.Videogame.VideogameResponse;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ListVideogameMapper  implements Function<Videogame, ListVideogameResponse> {
    @Override
    public ListVideogameResponse apply(Videogame videogame) {
        return new ListVideogameResponse(
                videogame.getName(),
                videogame.getDeveloper().getName()
        );
    }
}
