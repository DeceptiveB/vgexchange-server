package com.example.videogamexchange.payload.Post;


import com.example.videogamexchange.model.Comment;
import com.example.videogamexchange.payload.CommentResponse;

import java.util.List;

public record PostResponse(
        String body,
        String username,
        String videogame,
        List<CommentResponse> comments
        ) {
}
