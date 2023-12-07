package com.example.videogamexchange.specification;

import com.example.videogamexchange.model.Genre;
import com.example.videogamexchange.model.Post;
import com.example.videogamexchange.model.Videogame;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class VideogameSpecification {

    public static Specification<Videogame> isGenre(List<Integer> genre) {
        return (root, query, criteriaBuilder ) -> {
            query.distinct(true);
            return root.get("genres").get("id").in(genre);
        };
    }

    public static Specification<Videogame> hasDeveloper(String developer) {
        return(root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("developer").get("name"), developer);
    }

}
