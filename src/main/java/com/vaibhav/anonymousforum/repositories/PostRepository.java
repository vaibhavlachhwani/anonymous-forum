package com.vaibhav.anonymousforum.repositories;

import com.vaibhav.anonymousforum.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
