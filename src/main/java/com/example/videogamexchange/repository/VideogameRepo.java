package com.example.videogamexchange.repository;

import com.example.videogamexchange.model.Genre;
import com.example.videogamexchange.model.Videogame;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface VideogameRepo extends JpaRepository<Videogame, Integer> {

    Optional<Videogame> findByName(String name);
    Page<Videogame> findByDeveloper(Integer developerId, Pageable pageable);

    Page<Videogame> findByGenresIdIn(List<Integer> genreList, Pageable pageable);

    //Page<Videogame> findByReleaseDateBetweenAndNameLikeAndGenreIn(LocalDate start, LocalDate end, Pageable pageable);
}
