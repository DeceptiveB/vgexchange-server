package com.example.videogamexchange.repository;

import com.example.videogamexchange.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommentRepo extends JpaRepository<Comment, Integer> {
    //Page<Comment> findByUser(Integer userId, Pageable pageable);

    Page<Comment> findByPost(Integer postId, Pageable pageable);
}
