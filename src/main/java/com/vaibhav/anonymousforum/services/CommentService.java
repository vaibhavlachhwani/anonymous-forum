package com.vaibhav.anonymousforum.services;

import com.vaibhav.anonymousforum.dtos.CommentDTO;
import com.vaibhav.anonymousforum.dtos.CommentRequestDTO;
import com.vaibhav.anonymousforum.entities.Comment;
import com.vaibhav.anonymousforum.entities.Post;
import com.vaibhav.anonymousforum.entities.User;
import com.vaibhav.anonymousforum.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserService userService;

    public List<CommentDTO> getAllComments() {
        return commentRepository.findAll().stream()
                .map(CommentDTO::new)
                .collect(Collectors.toList());
    }

    public CommentDTO getCommentById(Long id) {
        return commentRepository.findById(id)
                .map(CommentDTO::new)
                .orElse(null);
    }

    public CommentDTO createComment(Comment comment) {
        Comment savedComment = commentRepository.save(comment);
        return new CommentDTO(savedComment);
    }

    public Comment createComment(String content, Post post, User user) {
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setPost(post);
        comment.setUser(user);
        return commentRepository.save(comment);
    }
}
