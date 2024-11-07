package com.vaibhav.anonymousforum.dtos;

import com.vaibhav.anonymousforum.entities.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserDTO {

    private Long id;
    private String username;
    private List<PostDTO> posts;

    // Constructor for creating UserDTO from a User entity
    public UserDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.posts = user.getPosts().stream()
                .map(PostDTO::new)  // Convert Post entities to PostDTOs
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<PostDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PostDTO> posts) {
        this.posts = posts;
    }
}
