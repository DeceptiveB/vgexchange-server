package com.example.videogamexchange.service;

import com.example.videogamexchange.exception.BadRequestException;
import com.example.videogamexchange.exception.ResourceNotFoundException;
import com.example.videogamexchange.model.user.AppUser;
import com.example.videogamexchange.payload.ApiResponse;
import com.example.videogamexchange.payload.AppUserRequest;
import com.example.videogamexchange.payload.AppUserResponse;
import com.example.videogamexchange.repository.AppUserRepo;
import com.example.videogamexchange.repository.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Service
public class AppUserService {
    @Autowired
    private AppUserRepo appUserRepo;

    @Autowired
    private PostRepo postRepo;

    public ResponseEntity<ApiResponse> saveUser(AppUserRequest appUserRequest){
        if (appUserRepo.existsByEmail(appUserRequest.email())){
            ApiResponse apiResponse = new ApiResponse(Boolean.FALSE, "Email is already taken.");
            throw new BadRequestException(apiResponse);
        }if (appUserRepo.existsByUsername(appUserRequest.username())){
            ApiResponse apiResponse = new ApiResponse(Boolean.FALSE, "Username is already taken.");
            throw new BadRequestException(apiResponse);
        }

        AppUser appUser = new AppUser();

        appUser.setName(appUserRequest.name());
        appUser.setEmail(appUserRequest.email());
        appUser.setPassword(appUserRequest.password());
        appUser.setUsername(appUserRequest.username());

        AppUser user = appUserRepo.save(appUser);

        AppUserResponse userResponse = new AppUserResponse();

        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/users/{userid}").buildAndExpand(appUser.getId()).toUri();

        return ResponseEntity.created(uri).body(new ApiResponse(Boolean.TRUE, "User registered successfully"));
    }

    public AppUserResponse getUser(String username){
        AppUser appUser = appUserRepo.findByUsername(username).
                orElseThrow(() -> new ResourceNotFoundException("Username","id",username));

        Long postCount = postRepo.countByUserId(appUser.getId());

        return new AppUserResponse(appUser.getId(), appUser.getName(), appUser.getEmail(), appUser.getUsername(), postCount, appUser.getEnabled() );
    }
}
