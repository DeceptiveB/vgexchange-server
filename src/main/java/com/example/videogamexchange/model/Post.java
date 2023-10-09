package com.example.videogamexchange.model;

import com.example.videogamexchange.model.user.AppUser;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table
public class Post {

    @Id
    @SequenceGenerator(
            name = "post_id_sequence",
            sequenceName = "post_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "post_id_sequence"
    )
    private Integer id;

    @Size(max = 80)
    private String body;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private AppUser user;

    @ManyToOne
    @JoinColumn(name = "videogame_id")
    private Videogame videogame;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    @Column(columnDefinition = "boolean default true")
    private Boolean isEnabled = true;

    public Post() {
    }

    public Post(Integer id, String body, AppUser user, Videogame videogame) {
        this.id = id;
        this.body = body;
        this.user = user;
        this.videogame = videogame;
    }

    public Post(String body, AppUser user, Videogame videogame) {
        this.body = body;
        this.user = user;
        this.videogame = videogame;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public Videogame getVideogame() {
        return videogame;
    }

    public void setVideogame(Videogame videogame) {
        this.videogame = videogame;
    }

    public List<Comment> getComments() {
        return comments == null ? null : new ArrayList<>(comments);
    }

    public void setComments(List<Comment> comments) {
        if (comments == null) {
            this.comments = null;
        }else {
            this.comments = Collections.unmodifiableList(comments);
        }
    }
}
