package com.github.zoyart.exampleSpring.module.Book.repository;

import com.github.zoyart.exampleSpring.module.Book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
