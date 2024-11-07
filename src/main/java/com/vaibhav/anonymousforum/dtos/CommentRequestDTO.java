package com.vaibhav.anonymousforum.dtos;

public class CommentRequestDTO {
    private String content;
    private Long userId; // ID of the user making the comment

    public CommentRequestDTO() {}

    public CommentRequestDTO(String content, Long userId) {
        this.content = content;
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
