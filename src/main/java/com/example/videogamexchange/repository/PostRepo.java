package com.example.videogamexchange.repository;

import com.example.videogamexchange.model.Post;
import com.example.videogamexchange.model.Videogame;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer> {

    Page<Post> findByVideogame(Integer videogameId, Pageable pageable);

    Page<Post> findByUser(Integer userId, Pageable pageable);
}
