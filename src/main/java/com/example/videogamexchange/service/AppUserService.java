package com.example.videogamexchange.service;

import com.example.videogamexchange.exception.BadRequestException;
import com.example.videogamexchange.model.user.AppUser;
import com.example.videogamexchange.payload.ApiResponse;
import com.example.videogamexchange.repository.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserService {
    @Autowired
    private AppUserRepo appUserRepo;

    public AppUser saveUser(AppUser appUser){
        if (appUserRepo.existsByEmail(appUser.getEmail())){
            ApiResponse apiResponse = new ApiResponse(Boolean.FALSE, "Email is already taken.");
            throw new BadRequestException(apiResponse);
        }if (appUserRepo.existsByUsername(appUser.getUsername())){
            ApiResponse apiResponse = new ApiResponse(Boolean.FALSE, "Username is already taken.");
            throw new BadRequestException(apiResponse);
        }
        return appUserRepo.save(appUser);
    }
}
