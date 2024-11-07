package com.vaibhav.anonymousforum.dtos;

import com.vaibhav.anonymousforum.entities.Comment;

public class CommentDTO {

    private Long id;
    private String content;
    private UserSummaryDTO user; // Summary of user info

    // Constructor for creating CommentDTO from a Comment entity
    public CommentDTO(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.user = new UserSummaryDTO(comment.getUser());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public UserSummaryDTO getUser() {
        return user;
    }

    public void setUser(UserSummaryDTO user) {
        this.user = user;
    }
}
