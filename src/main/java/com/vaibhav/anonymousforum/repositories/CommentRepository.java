package com.vaibhav.anonymousforum.repositories;

import com.vaibhav.anonymousforum.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
