package com.example.videogamexchange.repository;

import com.example.videogamexchange.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends JpaRepository<Post, Integer>, JpaSpecificationExecutor<Post> {

    Page<Post> findByVideogame(Integer videogameId, Pageable pageable);



    Page<Post> findByUserId(Integer userId, Pageable pageable);

    Long countByUserId(Integer userId);


}
