package com.example.videogamexchange.specification;

import com.example.videogamexchange.model.Post;
import org.springframework.data.jpa.domain.Specification;

public class PostSpecification {
    public static Specification<Post> hasVideogame(Integer videogame){
        System.out.println("asdfasdfasfasdf");
        return (root, query, criteriaBuilder ) ->
            query.where()
    }
}
