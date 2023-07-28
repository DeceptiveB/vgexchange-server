package com.example.videogamexchange.payload;

import com.example.videogamexchange.model.user.Address;

public class AppUserResponse {

    private Integer id;

    private Boolean isEnabled;

    private String name;

    private String email;

    private String username;

    private Long postCount;

    public AppUserResponse() {
    }

    public AppUserResponse(Integer id, String name, String email, String username, Long postCount, Boolean isEnabled) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.username = username;
        this.postCount = postCount;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String uesrname) {
        this.username = uesrname;
    }

    public Long getPostCount() {
        return postCount;
    }

    public void setPostCount(Long postCount) {
        this.postCount = postCount;
    }
}
