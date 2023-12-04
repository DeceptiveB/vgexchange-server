package com.example.videogamexchange.specification;

import com.example.videogamexchange.model.Post;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class PostSpecification {
    public static Specification<Post> hasVideogame(List<Integer> videogame){
        System.out.println("asdfasdfasfasdf");
        return (root, query, criteriaBuilder ) ->
            root.get("videogame").get("id").in(videogame);
    }
}
