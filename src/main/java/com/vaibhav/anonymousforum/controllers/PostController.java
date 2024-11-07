package com.vaibhav.anonymousforum.controllers;

import com.vaibhav.anonymousforum.dtos.PostDTO;
import com.vaibhav.anonymousforum.entities.Post;
import com.vaibhav.anonymousforum.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    // Get all posts
    @GetMapping
    public List<PostDTO> getAllPosts() {
        return postService.getAllPosts();
    }

    // Get a post by ID
    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable Long id) {
        PostDTO post = postService.getPostById(id);
        return post != null ? ResponseEntity.ok(post) : ResponseEntity.notFound().build();
    }

    // Create a new post
    @PostMapping
    public ResponseEntity<PostDTO> createPost(@RequestBody Post post) {
        PostDTO createdPost = postService.createPost(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
    }
}
