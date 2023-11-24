package com.example.videogamexchange.repository;

import com.example.videogamexchange.model.Genre;
import com.example.videogamexchange.model.Videogame;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public interface VideogameRepo extends JpaRepository<Videogame, Integer>, JpaSpecificationExecutor<Videogame> {

    Optional<Videogame> findByName(String name);
    Page<Videogame> findByDeveloper(Integer developerId, Pageable pageable);

    Page<Videogame> findByGenresIdIn(List<Integer> genreList, Pageable pageable);

    //Page<Videogame> findAll(Specification<Videogame> spec, Pageable pageable);

    //Page<Videogame> findByReleaseDateBetweenAndNameLikeAndGenreIn(LocalDate start, LocalDate end, Pageable pageable);
}
