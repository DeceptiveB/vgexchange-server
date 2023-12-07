package com.example.videogamexchange.mapper.Post;

import com.example.videogamexchange.model.Post;
import com.example.videogamexchange.payload.Post.ListPostResponse;
import com.example.videogamexchange.payload.Post.PostResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

@Service
public class ListPostMapper implements Function<Post, ListPostResponse> {

    @Override
    public ListPostResponse apply(Post post) {
        return new ListPostResponse(
                post.getId(),
                post.getBody(),
                post.getUser().getName(),
                post.getVideogame().getName(),
                post.getVideogame().getId()
        );
    }
}
