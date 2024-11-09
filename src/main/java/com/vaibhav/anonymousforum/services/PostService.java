package com.vaibhav.anonymousforum.services;

import com.vaibhav.anonymousforum.dtos.PostDTO;
import com.vaibhav.anonymousforum.dtos.PostRequestDTO;
import com.vaibhav.anonymousforum.entities.Post;
import com.vaibhav.anonymousforum.repositories.PostRepository;
import com.vaibhav.anonymousforum.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    public List<PostDTO> getAllPosts() {
        return postRepository.findAll().stream()
                .map(PostDTO::new)
                .collect(Collectors.toList());
    }

    public PostDTO getPostById(Long id) {
        return postRepository.findById(id)
                .map(PostDTO::new)
                .orElse(null);
    }

    public PostDTO createPost(Post post) {
        Post savedPost = postRepository.save(post);
        return new PostDTO(savedPost);
    }

    public Post createPost(PostRequestDTO postRequest) {
        Post post = new Post();
        post.setTitle(postRequest.getTitle());
        post.setContent(postRequest.getContent());
        post.setUser(userService.getUserObjByUsername(postRequest.getUsername()));
        return postRepository.save(post);
    }
}

