package com.example.videogamexchange.repository;

import com.example.videogamexchange.model.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeveloperRepo extends JpaRepository<Developer, Integer> {
    Optional<Developer> findByName(String name);
}
