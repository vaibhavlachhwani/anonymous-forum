package com.vaibhav.anonymousforum.dtos;

import com.vaibhav.anonymousforum.entities.User;

public class UserRequestDTO {
    private String username;
    private String password;

    public UserRequestDTO(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
