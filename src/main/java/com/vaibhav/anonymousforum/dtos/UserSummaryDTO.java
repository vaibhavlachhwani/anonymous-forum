package com.vaibhav.anonymousforum.dtos;

import com.vaibhav.anonymousforum.entities.User;

public class UserSummaryDTO {

    private Long id;
    private String username;

    // Constructor for summary from User entity
    public UserSummaryDTO(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
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
}
