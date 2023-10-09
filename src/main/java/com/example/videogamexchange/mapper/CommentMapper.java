package com.example.videogamexchange.mapper;

import com.example.videogamexchange.model.Comment;
import com.example.videogamexchange.payload.CommentResponse;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class CommentMapper implements Function<Comment, CommentResponse> {
    @Override
    public CommentResponse apply(Comment comment) {
        return new CommentResponse(
                comment.getBody(),
                comment.getUser().getName()
        );
    }
}
