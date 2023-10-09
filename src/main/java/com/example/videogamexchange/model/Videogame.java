package com.example.videogamexchange.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "videogame")
public class Videogame {

    @Id
    @SequenceGenerator(
            name = "videogame_id_sequence",
            sequenceName = "videogame_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "videogame_id_sequence"
    )
    private Integer id;

    @NotBlank
    private String name;


    @NotBlank
    @Size(max = 80)
    private String argument;

    @ManyToOne
    @JoinColumn(name = "developer_id")
    private Developer developer;


    @Column(
            name = "release_date"
    )
    private LocalDate releaseDate;

    @ManyToMany
    @JoinTable(
            name = "videogame_genre",
            joinColumns = @JoinColumn(name = "videogame_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    private List<Genre> genres;

    @OneToMany(
            mappedBy = "videogame"
    )
    private List<Post> posts;

    public Videogame() {
    }

    public Videogame(Integer id, String name, String argument, Developer developer, LocalDate releaseDate) {
        this.id = id;
        this.name = name;
        this.argument = argument;
        this.releaseDate = releaseDate;
        this.developer = developer;
    }

    public Videogame(String name, String argument, LocalDate releaseDate ,Developer developer, List<Genre> genres) {
        this.name = name;
        this.argument = argument;
        this.developer = developer;
        this.releaseDate = releaseDate;
        this.genres = genres;
    }

    public Videogame(String name, String argument, LocalDate releaseDate) {
        this.name = name;
        this.argument = argument;
        this.releaseDate = releaseDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArgument() {
        return argument;
    }

    public void setArgument(String argument) {
        this.argument = argument;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Developer getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developer developer) {
        this.developer = developer;
    }

    public List<Genre> getGenres() {
        return genres == null ? null : new ArrayList<>(genres);
    }

    public void setGenres(List<Genre> genres) {
        if (genres == null){
            this.genres = null;
        }else {
            this.genres = Collections.unmodifiableList(genres);
        }
    }

    public List<Post> getPosts() {
        return posts == null ? null : new ArrayList<>(posts);
    }

    public void setPosts(List<Post> posts) {
        if (posts == null){
            this.posts = null;
        }else {
            this.posts = Collections.unmodifiableList(posts);
        }
    }
}
