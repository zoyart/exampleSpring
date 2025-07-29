package com.github.zoyart.exampleSpring.module.Book.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookShowDTO {
    private long id;
    private String name;
    private String author;
    private int pageCount;
}
