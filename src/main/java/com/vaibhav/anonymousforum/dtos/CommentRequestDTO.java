package com.vaibhav.anonymousforum.dtos;

import com.vaibhav.anonymousforum.entities.Post;

public class CommentRequestDTO {
    private String username;
    private String password;
    private String content;

    public CommentRequestDTO() {
    }

    public CommentRequestDTO(String username, String password, String content) {
        this.username = username;
        this.password = password;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
