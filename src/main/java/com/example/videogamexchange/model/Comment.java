package com.example.videogamexchange.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.apache.catalina.User;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @SequenceGenerator(
            name = "comment_id_sequence",
            sequenceName = "comment_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "comment_id_sequence"
    )
    private Integer id;
    @NotBlank
    @Size(max = 40)
    private String body;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Comment() {
    }

    public Comment(Integer id, String body, Post post, User user) {
        this.id = id;
        this.body = body;
        this.post = post;
        this.user = user;
    }

    public Comment(String body, Post post, User user) {
        this.body = body;
        this.post = post;
        this.user = user;
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
