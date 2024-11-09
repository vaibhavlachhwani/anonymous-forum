package com.vaibhav.anonymousforum.controllers;

import com.vaibhav.anonymousforum.dtos.CommentDTO;
import com.vaibhav.anonymousforum.dtos.CommentRequestDTO;
import com.vaibhav.anonymousforum.entities.Comment;
import com.vaibhav.anonymousforum.services.CommentService;
import com.vaibhav.anonymousforum.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*") // Allow CORS for this method
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    // Get all comments
    @GetMapping
    public List<CommentDTO> getAllComments() {
        return commentService.getAllComments();
    }

    // Get a comment by ID
    @GetMapping("/{id}")
    public ResponseEntity<CommentDTO> getCommentById(@PathVariable Long id) {
        CommentDTO comment = commentService.getCommentById(id);
        return comment != null ? ResponseEntity.ok(comment) : ResponseEntity.notFound().build();
    }
}
