package com.example.videogamexchange.service;

import com.example.videogamexchange.exception.ResourceNotFoundException;
import com.example.videogamexchange.mapper.Post.ListPostMapper;
import com.example.videogamexchange.mapper.Post.PostMapper;
import com.example.videogamexchange.model.Post;
import com.example.videogamexchange.payload.Post.ListPostResponse;
import com.example.videogamexchange.payload.Post.PostResponse;
import com.example.videogamexchange.repository.PostRepo;
import com.example.videogamexchange.specification.PostSpecification;
import com.example.videogamexchange.specification.VideogameSpecification;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private ListPostMapper listPostMapper;

    @Autowired
    private PostRepo postRepo;

    public List<ListPostResponse> getAllPosts(
            List<Integer> videogames,
            int page,
            int nElements
    ){
        Specification<Post> spec = Specification.where(null);
        if (videogames != null){
            spec = spec.and(PostSpecification.hasVideogame(videogames));
        }
        Pageable pageable = PageRequest.of(page, nElements);
        return postRepo
                .findAll(spec, pageable)
                .stream()
                .map(listPostMapper)
                .collect(Collectors.toList());
    }

    public List<ListPostResponse> getPostsByUser(
            Integer userId,
            int page,
            int nElements
    ){
        Pageable pageable = PageRequest.of(page, nElements);
        return postRepo
                .findByUserId(userId, pageable)
                .stream()
                .map(listPostMapper)
                .collect(Collectors.toList());
    }

    /*public PostResponse getPostsByCategory(<List<Integer> genres){

    }*/


    public PostResponse getPostById(Integer id){
         return postRepo.findById(id)
                .map(postMapper)
                .orElseThrow(
                () -> new ResourceNotFoundException("user", "id", id)
        );
    }
}
