package com.example.videogamexchange.payload.Post;

public record ListPostResponse (
        Integer id,
        String body,
        String username,
        String videogame
){
}
