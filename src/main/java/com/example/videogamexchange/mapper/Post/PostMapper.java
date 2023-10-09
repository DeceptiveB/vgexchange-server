package com.example.videogamexchange.mapper.Post;

import com.example.videogamexchange.mapper.CommentMapper;
import com.example.videogamexchange.model.Post;
import com.example.videogamexchange.payload.Post.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class PostMapper implements Function<Post, PostResponse> {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public PostResponse apply(Post post) {

        return new PostResponse(
                post.getBody(),
                post.getUser().getName(),
                post.getVideogame().getName(),
                post.getComments().stream().map(commentMapper).collect(Collectors.toList())
        );
    }
}
