package com.example.videogamexchange.repository;

import com.example.videogamexchange.model.Videogame;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VideogameRepo extends JpaRepository<Videogame, Integer> {

    Optional<Videogame> findByName(String name);
    Page<Videogame> findByDeveloper(Integer developerId, Pageable pageable);
}
