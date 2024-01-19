package com.example.videogamexchange.controller;

import com.example.videogamexchange.model.Post;
import com.example.videogamexchange.payload.Post.ListPostResponse;
import com.example.videogamexchange.payload.Post.PostResponse;
import com.example.videogamexchange.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;


    @GetMapping("/post")
    public ResponseEntity<List<ListPostResponse>> getAllPosts(
            @RequestParam(
                    value = "videogames",
                    required = false) List<Integer> videogames,
            @RequestParam(
                    value = "page",
                    required = false,
                    defaultValue = "0") Integer page,
            @RequestParam(value = "quantity",
                    required = false,
                    defaultValue = "5") Integer nElements
    ){
        System.out.println(videogames);
        List<ListPostResponse> posts = postService.getAllPosts(videogames, page, nElements);
        return ResponseEntity.ok().body(posts);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ListPostResponse>> getPostsByUser(
            @PathVariable(
                    value="userId") Integer postId,
            @RequestParam(
                    value = "page",
                    required = false,
                    defaultValue = "0") Integer page,
            @RequestParam(
                    value = "quantity",
                    required = false,
                    defaultValue = "5") Integer nElements){
        List<ListPostResponse> postResponse = postService.
                getPostsByUser(
                        postId,
                        page,
                        nElements);

        return ResponseEntity.ok().body(postResponse);
    }



    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> getPostById(
            @PathVariable(value="id") Integer id
    ){
        return ResponseEntity.ok().body(postService.getPostById(id));
    }
}

