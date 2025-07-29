package com.github.zoyart.exampleSpring.module.User.repository;

import com.github.zoyart.exampleSpring.module.User.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @EntityGraph(attributePaths = {"books"})
    Optional<User> findById(Long id);
}
