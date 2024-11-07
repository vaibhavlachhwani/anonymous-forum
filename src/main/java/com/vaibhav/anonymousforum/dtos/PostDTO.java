package com.vaibhav.anonymousforum.dtos;

import com.vaibhav.anonymousforum.entities.Post;

import java.util.List;
import java.util.stream.Collectors;

public class PostDTO {

    private Long id;
    private String title;
    private String content;
    private UserSummaryDTO user; // Summary of user info, to avoid recursion
    private List<CommentDTO> comments;

    // Constructor to create PostDTO from a Post entity
    public PostDTO(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.user = new UserSummaryDTO(post.getUser());
        this.comments = post.getComments().stream()
                .map(CommentDTO::new)  // Convert Comment entities to CommentDTOs
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public List<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }
}
