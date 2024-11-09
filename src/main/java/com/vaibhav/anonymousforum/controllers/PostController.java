package com.vaibhav.anonymousforum.controllers;

import com.vaibhav.anonymousforum.dtos.PostDTO;
import com.vaibhav.anonymousforum.dtos.PostRequestDTO;
import com.vaibhav.anonymousforum.repositories.CommentRepository;
import com.vaibhav.anonymousforum.repositories.PostRepository;
import com.vaibhav.anonymousforum.repositories.UserRepository;
import com.vaibhav.anonymousforum.services.PostService;
import com.vaibhav.anonymousforum.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*") // Allow CORS for this method
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private UserRepository userRepository;

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

    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody PostRequestDTO postRequestDTO) {
        System.out.println("Received Title: " + postRequestDTO.getTitle());
        boolean isAuthenticated = userService.verifyUser(postRequestDTO.getUsername(), postRequestDTO.getPassword());
        if (!isAuthenticated) {
            return ResponseEntity.status(401).body("Authentication failed. Invalid user ID or password.");
        }

        PostDTO postDTO = new PostDTO(postService.createPost(postRequestDTO));
        return ResponseEntity.ok(postDTO);
    }

//    @PostMapping("/{id}/comments")
//    public ResponseEntity<CommentDTO> addCommentToPost(@PathVariable Long id, @RequestBody CommentRequestDTO commentRequestDTO) {
//        Optional<Post> postOptional = postRepository.findById(id);
//        if (!postOptional.isPresent()) {
//            return ResponseEntity.notFound().build();
//        }
//
//        Post post = postOptional.get();
//
//        // Assume we have a method to get the current user
//        User user = userRepository.findById(commentRequestDTO.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
//
//        // Create and save the new comment
//        Comment comment = new Comment();
//        comment.setContent(commentRequestDTO.getContent());
//        comment.setPost(post);
//        comment.setUser(user);  // Set the user who made the comment
//        comment = commentRepository.save(comment);
//
//        // Convert saved comment to CommentDTO
//        CommentDTO commentDTO = new CommentDTO(comment);
//        return ResponseEntity.ok(commentDTO);
//    }
}
