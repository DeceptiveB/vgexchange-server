package com.example.videogamexchange.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "genre")
public class Genre {

    @Id
    @SequenceGenerator(
            name = "genre_id_sequence",
            sequenceName = "genre_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "genre_id_sequence"
    )
    private Integer id;

    @NotBlank
    @Size(max = 50)
    private String name;

    @ManyToMany(mappedBy = "genres")
    private List<Videogame> videogames;

    public Genre(String name) {
        this.name = name;
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

    public List<Videogame> getVideogames() {
        return videogames == null ? null : new ArrayList<>(videogames);
    }

    public void setVideogames(List<Videogame> videogames) {
        if (videogames == null){
            this.videogames = null;
        } else {
            this.videogames = Collections.unmodifiableList(videogames);
        }
    }
}
