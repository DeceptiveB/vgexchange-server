package com.example.videogamexchange.controller;

import com.example.videogamexchange.payload.ApiResponse;
import com.example.videogamexchange.payload.AppUserRequest;
import com.example.videogamexchange.payload.AppUserResponse;
import com.example.videogamexchange.repository.PostRepo;
import com.example.videogamexchange.service.AppUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping()
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @Autowired
    private PostRepo postRepo;

    public ResponseEntity<ApiResponse> addUser(@Valid @RequestBody AppUserRequest appUserRequest){
        return appUserService.saveUser(appUserRequest);
    }

    public ResponseEntity<AppUserResponse> getAppUser(@PathVariable(value="username") String username){
        AppUserResponse appUserResponse = appUserService.getUser(username);

        return ResponseEntity.ok().body(appUserResponse);
    }

    //public ResponseEntity<ApiResponse> updateUser(@)

    public Long getNumberOfPosts(@PathVariable(value="id") Integer userId){
        return postRepo.countByUserId(userId);
    }
}
