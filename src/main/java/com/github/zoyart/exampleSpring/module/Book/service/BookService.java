package com.github.zoyart.exampleSpring.module.Book.service;

import com.github.zoyart.exampleSpring.module.Book.dto.BookCreateDTO;
import com.github.zoyart.exampleSpring.module.Book.dto.BookPatchDTO;
import com.github.zoyart.exampleSpring.module.Book.dto.BookShowDTO;
import com.github.zoyart.exampleSpring.module.Book.dto.BookUpdateDTO;
import com.github.zoyart.exampleSpring.module.Book.mapper.BookMapper;
import com.github.zoyart.exampleSpring.module.Book.model.Book;
import com.github.zoyart.exampleSpring.module.Book.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class BookService {
    private final BookMapper bookMapper;
    private final BookRepository bookRepository;

    public BookService(BookMapper bookMapper, BookRepository bookRepository) {
        this.bookMapper = bookMapper;
        this.bookRepository = bookRepository;
    }

    public BookShowDTO getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book with id " + id + " not found"));

        return bookMapper.toBookShowDTO(book);
    }

    public List<BookShowDTO> getAllBooks() {
        return bookMapper.toBookShowDTOs(bookRepository.findAll());
    }

    public void createBook(BookCreateDTO bookCreateDTO) {
        Book book = new Book();
        bookMapper.createBookFromDTO(bookCreateDTO, book);

        bookRepository.save(book);
    }

    public void updateBook(Long id, BookUpdateDTO bookUpdateDTO) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book with id " + id + " not found"));

        bookMapper.updateBookFromDTO(bookUpdateDTO, book);
        bookRepository.save(book);
    }

    public void patchBook(Long id, BookPatchDTO bookPatchDTO) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book with id " + id + " not found"));

        bookMapper.patchBookFromDTO(bookPatchDTO, book);
        bookRepository.save(book);
    }

    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }
}
