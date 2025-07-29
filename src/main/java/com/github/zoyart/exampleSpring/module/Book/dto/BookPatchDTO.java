package com.github.zoyart.exampleSpring.module.Book.dto;

import lombok.Getter;
import org.springframework.stereotype.Service;

@Getter
@Service
public class BookPatchDTO {
    private String name;
    private String author;
    private int pageCount;
}
