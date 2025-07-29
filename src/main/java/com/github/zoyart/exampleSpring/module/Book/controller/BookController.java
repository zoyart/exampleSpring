package com.github.zoyart.exampleSpring.module.Book.controller;

import com.github.zoyart.exampleSpring.module.Book.dto.BookCreateDTO;
import com.github.zoyart.exampleSpring.module.Book.dto.BookPatchDTO;
import com.github.zoyart.exampleSpring.module.Book.dto.BookShowDTO;
import com.github.zoyart.exampleSpring.module.Book.dto.BookUpdateDTO;
import com.github.zoyart.exampleSpring.module.Book.mapper.BookMapper;
import com.github.zoyart.exampleSpring.module.Book.service.BookService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    public BookShowDTO getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping
    public List<BookShowDTO> getBookById() {
        return bookService.getAllBooks();
    }

    @PostMapping
    public void createBook(@RequestBody BookCreateDTO bookCreateDTO) {
        bookService.createBook(bookCreateDTO);
    }

    @PutMapping("/{id}")
    public void updateBook(@PathVariable Long id, @RequestBody BookUpdateDTO bookUpdateDTO) {
        bookService.updateBook(id, bookUpdateDTO);
    }

    @PatchMapping("/{id}")
    public void patch(@PathVariable Long id, @RequestBody BookPatchDTO bookPatchDTO) {
        bookService.patchBook(id, bookPatchDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
